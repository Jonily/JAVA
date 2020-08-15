package util;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class OrderSystemUtil {
    //实现一个读取body的功能
    //需要先把整个body读取出来再进行解析json

    public  static String readBody(HttpServletRequest request) throws UnsupportedEncodingException {
        //先获取到body的长度（单位为字节）
        int length = request.getContentLength();
        byte[] buffer = new byte[length];
        try(InputStream inputStream = request.getInputStream()){

            inputStream.read(buffer,0,length);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(buffer,"UTF-8");
    }

}
