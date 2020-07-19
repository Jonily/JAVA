package API;

import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //浏览器是通过POST方法提交注册信息给服务器的

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html; charset-utf-8");
        //1、获取到前端提交的数据（用户名、密码），校验是否合格
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(name == null || "".equals(name)
        || password == null || "".equals(password)){
            //用户提交的数据有误
            //返回一个错误页面（一段字符串，html构成得到）
            String html  = HtmlGenerator.getMessagePage("用户名或者密码为空","register.html");
            resp.getWriter().write(html);
            return;
        }
        //2、拿着用户名在数据库中查一下，看看当前用户是否已经存在，如果存在，认为注册失败
        //3、对比密码是否匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(name);
        if(user !=null || !password.equals(user.getPassword())){
            //用户名不存在，提示错误
            String html = HtmlGenerator.getMessagePage("用户名或者密码错误！",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }

        //4、匹配成功，提示当前登录成功，创建一个Session
        //Servlet 中本来就实现了Session 管理.管理用户的登陆状态.自动分配-个sessionld,和Session对象以键值对得到形式组织然后保存起来.同时把Sessionld以Set-Copkie的形式返回给浏览器.
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("user",user);

        //5、返回一个登陆成功的提示页面
        String html = HtmlGenerator.getMessagePage("登陆成功！",
                "article");
        resp.getWriter().write(html);

    }
}
