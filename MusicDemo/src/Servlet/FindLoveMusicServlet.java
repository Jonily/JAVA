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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findLoveMusic")
public class FindLoveMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String LoveMusicName = req.getParameter("loveMusicName");

        MusicDao musicDao = new MusicDao();

        List<Music> musicList = new ArrayList<>();

        User user = (User)req.getSession().getAttribute("user");
        int userId = user.getId();

        if(LoveMusicName != null){
            musicList = musicDao.ifMusicLove(LoveMusicName,userId);

        }else {
            musicList = musicDao.findLoveMusicByUserId(userId);

        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),musicList);

    }
}
