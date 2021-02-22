package com.my.controller;



import com.my.pojo.Music;
import com.my.pojo.User;
import com.my.service.MusicService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/music")
public class MusicController {
    //controller层调用service层
    @Autowired
    @Qualifier("MusicServiceImpl")
    private MusicService musicService;

     //1、查询全部歌单-->
    @RequestMapping("/allMusic")
    @ResponseBody
    public void allMusic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String musicName = request.getParameter("musicName");
        List<Music> list = new ArrayList<Music>();
        System.out.println("MusicController.allMusic"+"======"+musicName);

        if(musicName != null){
            list = musicService.findMusicByStr(musicName);
        }else {
            list = musicService.findMusic();
        }
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }



    //2、歌曲添加我喜欢中
    @RequestMapping("/insertLoveMusic")
    @ResponseBody
    public void insertLoveMusic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        int musicId = Integer.parseInt(idStr);

        Map<String,Object> return_map = new HashMap<String,Object>();

        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();
        if(musicService.findLoveMusicByMusicIdAndUserId(userId,musicId)){
            //这首歌已经被添加为喜欢
            return_map.put("msg",false);

        }else {
            if(musicService.insertLoveMusic(userId,musicId)) {
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

    @RequestMapping("/findMyLoveMusic")
    @ResponseBody
    public void findLoveMusic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String LoveMusicName = request.getParameter("loveMusicName");
        List<Music> list = new ArrayList<Music>();
        System.out.println("MusicController.allMusic"+"======"+LoveMusicName);
        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();
        if(LoveMusicName!= null){
            list = musicService.findLoveMusicByStr(LoveMusicName,userId);
        }else {
            list = musicService.findLoveMusicByUserId(userId);
        }
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }

    //4、移除我喜欢
    @RequestMapping("/removeLoveMusic")
    @ResponseBody
    public void removeLoveMusic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        int musicId = Integer.parseInt(idStr);

        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();

        int ret = musicService.removeLoveMusic(userId,musicId);
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

    //5、批量删除歌曲-->
    @RequestMapping("/deleteMusicById")
    @ResponseBody
    public void deleteMusicById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String[] values = request.getParameterValues("id[]");
        User user = (User)request.getSession().getAttribute("user");
        String userName = user.getName();
        int count =0;
        Map<String,Object> return_map = new HashMap<String ,Object>();

        if(userName.equals("admin")){
            //数组中是所有要删除的id
            for (int i = 0; i <values.length ; i++) {
                int id = Integer.parseInt(values[i]);
                Music music = musicService.findMusicById(id);

                int ret = musicService.deleteMusicById(id);
                if(ret == 1){
                    //删除服务器上的
                    File file = new File("/root/apache-tomcat-8.5.61/webapps/"+music.getUrl()+".mp3");
                    if(file.delete()){
                        count+=ret;
                    }else {
                        return_map.put("msg",false);
                    }
                }else {
                    return_map.put("msg",false);

                }
            }
            if(count == values.length){
                return_map.put("msg",true);

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
    //6、删除歌曲-->
    @RequestMapping("/deleteMusic")
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
            Music music = musicService.findMusicById(id);
            if(music == null){
                return;

            }
            if(musicService.findLoverMusicById(id)){
                musicService.removeLoveMusicDelete(id);
            }
            int ret = musicService.deleteMusicById(id);
            //数据库删除还要删除服务器的
            if(ret == 1){
                //删除服务器上的
                File file = new File("/root/apache-tomcat-8.5.61/webapps/MusicPlayer/"+music.getUrl()+".mp3");
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

    private final String SavePath="/root/apache-tomcat-8.5.61/webapps/MusicPlayer/music";

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
                response.sendRedirect("/MusicPlayer/list.html");
            }
            InputStream is = file.getInputStream(); //文件输入流
            OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流
            //读取写出
            int len=0;
            byte[] buffer = new byte[1024];
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
                os.flush();
            }
            os.close();
            is.close();

          /*  //通过CommonsMultipartFile的方法直接写文件
            file.transferTo(new File(realPath +"\\"+ file.getOriginalFilename()));*/

            request.getSession().setAttribute("fileName",uploadFileName);

            System.out.println("MusicController.uploadMusic");
            //再从服务器上传到数据库

            response.sendRedirect("/MusicPlayer/uploadSuccess.html");
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

        String url = "music/"+title;
        int ret = musicService.AddMusic(new Music(0,title,singer,time,url));
        if(ret == 1){
            response.sendRedirect("/MusicPlayer/list.html");
        }
    }


}