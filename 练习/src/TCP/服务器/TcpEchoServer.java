package TCP.服务器;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    //1、初始化服务器
    //2、进入主循环
    //a、从内核获得TCP连接
    //b、处理TCP连接
      //（1）读取请求并解析
      //（2）根据请求计算响应
      //（3）把响应写回给客户端
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        //类似UCP服务器绑定端口
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1）先从内核中获取到一个TCP连接
            Socket clientSocket = serverSocket.accept();
            //2)处理连接
            processConnection(clientSocket);
        }
    }
    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s : %d] 客户端上线\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //通过clientSocket 来和客户端交互，先做好准备工作，获取到clientSocket中的流对象
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            //实现长连接 去掉while循环就是短链接
            //一次连接的处理过程中
            //当客户端断开连接退出循环，也就结束
            //当客户端断开连接的时候readLine 或者 write方法会触发异常
            while (true) {
                //1、读取请求并解析（readLine（）对应客户端发送数据的格式，必须是按行发送）
                String request = bufferedReader.readLine();//客户端发的数据必须是一个按行发送的数据
                // （相当于应用层的自定义协议，客户端发送也必须按行发送）
                //2、根据请求计算响应
                String response = process(request);
                //3、把响应写回到客户端(客户端按行读取)
                bufferedWriter.write(response+"\n");
                bufferedWriter.flush();
                System.out.printf("[%s : %d] ip :%s ; 端口: %s \n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.printf("[%s : %d] 客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }

    }
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();

    }
}
