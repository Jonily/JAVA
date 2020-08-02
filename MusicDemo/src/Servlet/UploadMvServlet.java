package Servlet;

import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/uploadMv")
public class UploadMvServlet extends HttpServlet {

    private final String SavePath="D:\\javaProgram\\JAVA\\MusicDemo\\web\\video";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        User user = (User) req.getSession().getAttribute("user");
        if(user == null){
            System.out.println("请登录后再上传！");
            resp.getWriter().write("<h2>请登录后再上传！</h2>");
            return;
        }else {
            //上传
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> fileItemList = null;
            try{
                fileItemList = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
                return;
            }
            System.out.println("fileItemList"+fileItemList);

            //获得文件列表中的第一个
            FileItem fileItem = fileItemList.get(0);
            System.out.println("fileItem"+fileItem);

            String fileName = fileItem.getName();
            req.getSession().setAttribute("fileName",fileName);


            try {
                fileItem.write(new File(SavePath,fileName));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            //再从服务器上传到数据库
            resp.sendRedirect("uploadMvSuccess.html");
        }
    }
}
