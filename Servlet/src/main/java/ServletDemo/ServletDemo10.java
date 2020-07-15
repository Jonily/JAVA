package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


@MultipartConfig
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收到图片，直接把图片保存到路径 d:/javaResource
        //提前准备目录
        String basePath = "d:/javaResource/images/";
        Part image = req.getPart("image");
        //获取想要上传的文件名
        String path = basePath + image.getSubmittedFileName();
        //image.getContentType() 得到图片的格式
        image.write(path);//图片想要保存的路径


        resp.setContentType("text/html; charset = utf-8");
        resp.getWriter().write("图片上传成功！");
    }
}
