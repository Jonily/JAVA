package TCP.客户端;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    //1、启动客户端（不绑定端口）和服务器建立连接
    //2、进入主循环
    //  a、读取用户输入内容
    //  b、构造一个请求发送给服务器
    //  c、读取服务器的响应数据
    //  d、把响应数据显示到界面
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        //从此处的实例化Socket过程，就是建立Ip连接
        socket = new Socket(serverIp,serverPort);
    }
    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner in = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            while (true){
                //  a、读取用户输入内容
                System.out.println("->");
                String request = in.nextLine();
                if("exit".equals(request)){
                    break;
                }
                //  b、构造一个请求发送给服务器
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                //\n是为了和服务器中的readLine相对应 读取和发送都是按行发送读取
                //按行读 按行写是一种简单的自定义协议

                //  c、读取服务器的响应数据
                String response = bufferedReader.readLine();//读取响应和服务器返回响应对应，只读一行忽略\n
                // 自定义协议请求和响应不一定要一致

                //  d、把响应数据显示到界面
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        //127.0.0.1表示环回ip，自己访问自己，刚刚所写的服务器和客户端都是在一个主机上，所以使用这个ip
        //如果不在同一个主机上，此处的ip就要写成要访问的服务器ip，9090就是上面写的服务器的端口号
        tcpEchoClient.start();
    }

}
