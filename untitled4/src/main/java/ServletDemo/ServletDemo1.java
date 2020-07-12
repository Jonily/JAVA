package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");


        String encoding = req.getCharacterEncoding();
        String contentType = req.getContentType();
        String contextPath = req.getContextPath();
        String ua = req. getHeader( "User -Agent");
        String host = req . getHeader(  "Host" );
        String method = req . getMethod();
        String protocol = req. getProtocol();
        String queryString = req. getQueryString();
        String url = req. getRequestURI();
        int contentLength = req. getContentLength();

        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("encoding: "+ encoding);
        writer.write("contentType: "+ contentType);




    }
}
