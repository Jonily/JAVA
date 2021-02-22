package com.my.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.pojo.Mv;
import com.my.pojo.User;
import com.my.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.*;
@Controller
@RequestMapping("/mv")
public class MvController {
    //controller层调用service层
    @Autowired
    @Qualifier("MvServiceImpl")
    private MvService mvService;

    //1、查询全部歌单-->
    @RequestMapping("/allMv")
    @ResponseBody
    public void allMv(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String mvName = request.getParameter("mvName");
        List<Mv> list = new ArrayList<Mv>();
        System.out.println("MvController.allMv"+"======"+mvName);

        if(mvName != null){
            list = mvService.findMvByStr(mvName);
        }else {
            list = mvService.findMv();
        }
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }

    //2、歌曲添加我喜欢中
    @RequestMapping("/insertLoveMv")
    @ResponseBody
    public void insertLoveMv(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        int mvId = Integer.parseInt(idStr);

        Map<String,Object> return_map = new HashMap<String,Object>();

        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();
        if(mvService.findLoveMvByMvIdAndUserId(userId,mvId)){
            //这首歌已经被添加为喜欢
            return_map.put("msg",false);

        }else {
            if(mvService.insertLoveMv(userId,mvId)) {
                return_map.put("msg",true);
            }else {
                return_map.put("msg",false);
            }
        }
        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),return_map);
    }

    //<!--3、查询我喜欢中的全部歌单-->

    @RequestMapping("/findMyLoveMv")
    @ResponseBody
    public void findLoveMv(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String LoveMvName = request.getParameter("loveMvName");
        List<Mv> list = new ArrayList<Mv>();
        System.out.println("MvController.allMv"+"======"+LoveMvName);
        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();
        if(LoveMvName!= null){
            list = mvService.findLoveMvByStr(LoveMvName,userId);
        }else {
            list = mvService.findLoveMvByUserId(userId);
        }
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }

    //4、移除我喜欢
    @RequestMapping("/removeLoveMv")
    @ResponseBody
    public void removeLoveMv(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        int mvId = Integer.parseInt(idStr);

        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();

        int ret = mvService.removeLoveMv(userId,mvId);
        Map<String,Object> return_map = new HashMap<String,Object>();
        if(ret == 1){
            return_map.put("msg",true);

        }else {
            return_map.put("msg",false);

        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),return_map);
    }


    //6、删除mv-->
    @RequestMapping("/deleteMv")
    @ResponseBody
    public void deleteMusic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        User user = (User)request.getSession().getAttribute("user");
        String userName = user.getName();

        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Map<String,Object> return_map = new HashMap<String ,Object>();
        //msg    true
        if(userName.equals("admin")){
            Mv mv = mvService.findMvById(id);
            if(mv == null){
                return;

            }
            if(mvService.findLoverMvById(id)){
                mvService.removeLoveMvDelete(id);
            }
            int ret = mvService.deleteMvById(id);
            //数据库删除还要删除服务器的
            if(ret == 1){
                //删除服务器上的
                File file = new File("/root/apache-tomcat-8.5.61/webapps/MusicPlayer/"+ mv.getUrl()+".mp4");
                if(file.delete()){
                    return_map.put("msg",true);
                }else {
                    return_map.put("msg",false);

                }

            }else {
                return_map.put("msg",false);

            }
        }else {
            return_map.put("msg",false);

        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),return_map);

    }

    private final String SavePath="/root/apache-tomcat-8.5.61/webapps/MusicPlayer/video";

    //7、上传添加歌曲
    @RequestMapping("/upload")
    @ResponseBody
    public void uploadMusic(@RequestParam("filename") MultipartFile file , HttpServletRequest request, HttpServletResponse response) throws IOException{

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            System.out.println("请登录后再上传！");
            response.getWriter().write("<h2>请登录后再上传！</h2>");
            return;
        }else {
            //上传
            File realPath = new File(SavePath);
            //上传文件地址
            System.out.println("上传文件保存地址："+realPath);
            String uploadFileName = file.getOriginalFilename();
            //如果文件名为空，直接回到首页！
            if ("".equals(uploadFileName)){
                response.sendRedirect("/MusicPlayer/MV.html");
            }

            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));


            request.getSession().setAttribute("fileName",uploadFileName);

            System.out.println("MvController.uploadMusic");
            //再从服务器上传到数据库

            response.sendRedirect("/MusicPlayer/uploadMvSuccess.html");
        }
    }
    //8、上传添加歌曲成功
    @RequestMapping("/uploadSuccess")
    @ResponseBody
    public void uploadSuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String singer = request.getParameter("singer");
        String fileName = (String) request.getSession().getAttribute("fileName");
        //去掉mp3
        String[] s = fileName.split("\\.");
        String title = s[0];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        //2020-07-29
        String time = simpleDateFormat.format(new Date());

        String url = "video/"+title;
        int ret = mvService.AddMv(new Mv(0,title,singer,time,url));
        if(ret == 1){
            response.sendRedirect("/MusicPlayer/MV.html");
        }
    }

}
