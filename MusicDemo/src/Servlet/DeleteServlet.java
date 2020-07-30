package Servlet;

import DAO.MusicDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Music;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        MusicDao musicDao = new MusicDao();

        Music music = musicDao.findMusicById(id);
        if(music == null){
            return;

        }
        Map<String,Object> return_map = new HashMap<>();
        //msg    true
        int ret = musicDao.deleteMusicById(id);
            //数据库删除还要删除服务器的
        if(ret == 1){
                //删除服务器上的
            File file = new File("D:\\javaProgram\\JAVA\\MusicDemo\\web\\"+music.getUrl()+".mp3");
            if(file.delete()){
                return_map.put("msg",true);
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
