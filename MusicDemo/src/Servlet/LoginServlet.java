package Servlet;

import DAO.UserDao;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username+" "+password);
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        Map<String,Object> return_map = new HashMap<>();
        //msg    true

        if(user != null){
            System.out.println("登录成功！");
            //登陆成功就把用户信息写入session
            req.getSession().setAttribute("user",user);//绑定数据


            return_map.put("msg",true);
        }else {
            System.out.println("登陆失败！");
            return_map.put("msg",false);
        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
