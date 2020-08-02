package Servlet;

import DAO.MusicDao;
import DAO.MvDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loveMvServlet")
public class LoveMvServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");


        String idStr = req.getParameter("id");
        int mvId = Integer.parseInt(idStr);

        User user = (User)req.getSession().getAttribute("user");
        int userId = user.getId();

        Map<String,Object> return_map = new HashMap<>();
        MvDao mvDao = new MvDao();
        if(mvDao.findLoveMvByMvId(userId,mvId)){
            //这首歌已经被添加为喜欢
            return_map.put("msg",false);

        }else {
            if(mvDao.insertLoveMv(userId,mvId)) {
                return_map.put("msg",true);
            }else {
                return_map.put("msg",false);
            }
        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
