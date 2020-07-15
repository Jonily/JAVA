package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//服务器给浏览器写回Cookie
public class ServletDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、先构造Cookie对象，一个Cookie对象就是一个键值对
        Cookie userName = new Cookie("userName","hhh");
        Cookie age = new Cookie("age",18+"");
        //2、把Cookie放到响应中
        resp.addCookie(userName);
        resp.addCookie(age);
        //创建一个响应报文
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("返回Cookie成功！");


    }
}
