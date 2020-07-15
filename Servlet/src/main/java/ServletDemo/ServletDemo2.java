package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理表单数据
        ////此时无论参数是在url中，还是body 中，都能获取到
        ////此处GET和POST 的处理方式都是一 样的.
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        //构造一个响应页面
        resp.setContentType("text/html; charset=utf-8");
        //一旦调用getWriter方法，此时header的内容就不能更改
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("firstName: "+firstName);
        writer.write("<br/>");
        writer.write("secondMame: "+secondName);
        writer.write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
