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

        //此处有一个重要的注意事项!!构造String 的时候，必须要指定
        //该字符串的编码方式。(这个操作相当于就是把字节数据转成字符数据)
        //涉及到这样的转换，最好都加上编码方式.
        //如果不加，不一定100%出错，有定的风险.

        return new String(buffer,"UTF-8");
    }

}
