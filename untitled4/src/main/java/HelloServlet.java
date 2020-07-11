import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先写一个简单的hello world
        //请求无论是啥，响应都是固定返回一个helloworld
        resp.getWriter().write("<h1>hello servlet</h1>");//把一个字符串写入到
        super.doGet(req, resp);
    }
}
