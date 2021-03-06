package TCP.服务器;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            Socket clientSocket = serverSocket.accept();
            //针对这个连接，单独创建一个线程负责处理
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s : %d] 客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            while (true){
                //1、读取请求并解析
                String request = bufferedReader.readLine();
                //2、根据请求计算响应
                String response = process(request);
                //3、把相应写回到客户端
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();

                System.out.printf("[%s : %d] ip:%s; 端口:%s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        }catch (IOException e){
           // e.printStackTrace();
            System.out.printf("[%s : %d] 客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }

    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer tcpThreadEchoServer = new TcpThreadEchoServer(9090);
        tcpThreadEchoServer.start();
    }
}
