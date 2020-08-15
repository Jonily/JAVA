package API;

import DAO.UserDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    //读取json请求对象
    static class Request{
        public String name;
        public String password;
    }

    //构造json响应对象
    public class Response{
        public int ok;
        public String reason;
        public String name;
        public int isAdmin;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        try {
            // 1.读取body 数据
            String body = OrderSystemUtil.readBody(req);
            //2.将读取的数据解析成对象
            Request request = gson.fromJson(body,Request.class);
            // 3.按照用户名进行查找，并校验密码
            UserDao userDao = new UserDao();
            User user = userDao.selectByName(request.name);
            if(user == null || !user.getPassword().equals(request.password)){
                throw new OrderSystemException("用户名或密码错误！");
            }
            //4.如果登陆失败，返回错误提示
            // 5.如果登陆成功，就创建session对象，[重要]
            HttpSession session = req.getSession(false);
            session.setAttribute("user",user);

        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
        }
        // 6.结果写回给客户端

    }


    //对应到检测登录状态API

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        //1、获取当前用户的session，如果session不存在，认为未登录
        HttpSession session = req.getSession(false);
        if(session == null){
            throw  new OrderSystemException("当前未登录！");
        }
        //2、从session中获取user对象
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new OrderSystemException("当前未登录！");
        }
        //3、把user中
    }
}
