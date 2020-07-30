package Servlet;

import DAO.MusicDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


//音乐信息写入数据库
@WebServlet("/uploadSuccess")
public class UploadSuccess extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String singer = req.getParameter("singer");
        String fileName = (String) req.getSession().getAttribute("fileName");
        //去掉mp3

        String[] s = fileName.split("\\.");
        String title = s[0];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        //2020-07-29
        String time = simpleDateFormat.format(new Date());
        User user = (User)req.getSession().getAttribute("user");

        int userId = user.getId();
        String url = "music/"+title;
        MusicDao musicDao = new MusicDao();
        int ret = musicDao.Insert(title,singer,time,url,userId);
        if(ret == 1){
            resp.sendRedirect("list.html");

        }
    }
}
