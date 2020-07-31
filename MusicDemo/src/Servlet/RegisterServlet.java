package Servlet;


import DAO.UserDao;
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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String userName = req.getParameter("username");
        String password = req.getParameter("password");


        User registerUser = new User();
        registerUser.setUsername(userName);
        registerUser.setPassword(password);

        Map<String,Object> return_map = new HashMap<>();
        UserDao userDao = new UserDao();
        if(userDao.findUserByName(registerUser.getUsername())){
            return_map.put("msg",false);

        }else {
            userDao.register(registerUser);
            return_map.put("msg",true);
        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);






    }
}
