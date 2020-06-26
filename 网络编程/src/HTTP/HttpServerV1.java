package HTTP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    //HTTP底层要基于TCP实现，需要先按照TCP的基本格式进行开发
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            //1、获取连接
            Socket clientSocket = serverSocket.accept();
            //2、处理连接（使用短连接的方式实现）
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });

        }
    }

    private void process(Socket clientSocket)  {
        //由于HTTP协议是文本协议,所以使用字符流
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
           //下面操作严格按照HTTO协议进行
            //1、读取请求并解析
               //a）解析首行,三部分用空格分割
            String firstLine = bufferedReader.readLine();
            String[] firstLineToken = firstLine.split(" ");
            String method = firstLineToken[0];
            String ur1 = firstLineToken[1];
            String version = firstLineToken[2];
               //b）解析header,按行读取，然后按照冒号空格分割键值对
            Map<String,String> headers = new HashMap<>();
            String line = "";
            //readLine 读取一行的内容，是会自动去掉换行符，对于空行来说
            //去掉换行符就变成空字符串
            while ((line = bufferedReader.readLine())!=null && line.length() !=0){
                //不能使用：来切分，像referer 字段，里面的内容可能包含：
                String[] headerTokens = line.split(":");
                headers.put(headerTokens[0],headerTokens[1]);
            }
            //2、根据请求计算响应
            //3、把响应写回客户端

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
