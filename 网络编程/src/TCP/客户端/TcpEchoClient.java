package TCP.客户端;

import javax.jws.Oneway;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    //1.启动客户端(一定不要绑定端口号)
    // 2.进入主循环
    // a)读取用户输入内容
    // b)构造一个请求发送给服务器
    //c)读取服务器的响应数据


    private Socket socket = null;

    public TcpEchoClient(String serverIp,int severPort)throws IOException {
        //此处的实例化Socket过程，就是建立tcp连接
        socket = new Socket(serverIp,severPort);
    }


    public void start()throws IOException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            while (true){
                //1、读取用户输入
                System.out.println();
                String request = scanner.nextLine();
                if("exit".equals(request)){
                    break;
                }
                //2、构造请求并发送，此处+\n 是为了和服务器中的readLine相对应
                bufferedWriter.write(request + "\n");

                //3、读取响应数据
                String response = bufferedReader.readLine();
                //4、


            }
        }
    }




}
