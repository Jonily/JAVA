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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findLoveMv")
public class FindLoveMvServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String LoveMvName = req.getParameter("loveMvName");

        MvDao mvDao = new MvDao();

        List<MV> mvList = new ArrayList<>();

        User user = (User)req.getSession().getAttribute("user");
        int userId = user.getId();

        if(LoveMvName != null){
            mvList = mvDao.ifMvLove(LoveMvName,userId);

        }else {
            mvList = mvDao.findLoveMvByUserId(userId);

        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),mvList);
    }
}
