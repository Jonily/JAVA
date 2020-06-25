package TCP.服务器;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    //1、初始化服务器
    //2、进入主循环
    //1）先去从内核中获取到一个tcp的连接
    //2）处理tcp的连接
    //a）读取请求并解析
    //b）根据请求计算响应
    //C）把响应写回给客户端
    private ServerSocket serverSocket = null;


    public TcpEchoServer (int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1)先从内核中获取一个Tcp连接
            Socket clientSocket = serverSocket.accept();
            //2、处理连接
            processConnection(clientSocket);
        }

    }
    public void processConnection(Socket socket){



    }
}
