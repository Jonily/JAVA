package Servlet;

import DAO.MusicDao;
import DAO.MvDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.MV;
import entity.Music;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteMvServlet")
public class DeleteMvServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        User user = (User)req.getSession().getAttribute("user");
        String userName = user.getUsername();

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        MvDao mvDao = new MvDao();

        Map<String,Object> return_map = new HashMap<>();
        //msg    true
        if(userName.equals("admin")){
            MV mv = mvDao.findMvById(id);
            if(mv == null){
                return;

            }
            int ret = mvDao.deleteMvById(id);
            //数据库删除还要删除服务器的
            if(ret == 1){
                //删除服务器上的
                File file = new File("/root/apache-tomcat-8.5.57/webapps/MyMusicDemo/"+mv.getUrl()+".mp4");
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
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
