package Servlet;

import DAO.MusicDao;
import com.fasterxml.jackson.databind.ObjectMapper;
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


//批量删除
@WebServlet("/deleteSelMusicServlet")

public class DeleteSelMusicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String[] values = req.getParameterValues("id[]");

        User user = (User)req.getSession().getAttribute("user");
        String userName = user.getUsername();

        MusicDao musicDao = new MusicDao();
        int count =0;
        Map<String,Object> return_map = new HashMap<>();

        if(userName.equals("admin")){
            //数组中是所有要删除的id
            for (int i = 0; i <values.length ; i++) {
                int id = Integer.parseInt(values[i]);
                Music music = musicDao.findMusicById(id);

                int ret = musicDao.deleteMusicById(id);
                if(ret == 1){
                    //删除服务器上的
                    File file = new File("D:\\javaProgram\\JAVA\\MusicDemo\\web\\"+music.getUrl()+".mp3");
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
        mapper.writeValue(resp.getWriter(),return_map);


    }
}
