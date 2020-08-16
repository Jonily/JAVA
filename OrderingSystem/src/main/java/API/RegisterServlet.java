package API;


import DAO.UserDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
    }

    //实际开发中，异常处理的语法对处理逻辑中的一些情况是很有限的
    //这样就可以让try中包含的都是正常存粹的逻辑 catch中包含的是错误处理的逻辑
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            // 1.读取body 中的数据.
            String body = OrderSystemUtil.readBody(req);
            // 2.把body 数据解析成Request 对象(GSON)
            Request request = gson.fromJson(body,Request.class);
            // 3.查询数据库，看看当前的用户名是否存在，(如果存在，就提示已经被注册了)
            UserDao userDao = new UserDao();
            User existUser = userDao.selectByName(request.name);
            if(existUser != null){
                //当前用户名重复，就直接返回一个表示注册失败的信息
                throw new OrderSystemException("当前用户名已经存在！");
            }
            //4、把提交的用户密码构成User对象，插入数据库
            User user = new User();
            user.setName(request.name);
            user.setPassword(request.password);
            user.setIsAdmin(0);
            userDao.add(user);
            response.ok = 1;
            response.reason ="";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //5、构造响应数据
            String jsonString = gson.toJson(response);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(jsonString);
            //顺序不能颠倒. 一旦先获取writer对象了,此时再修改
            //contentType等header的属性就无效了.

        }

    }
}
