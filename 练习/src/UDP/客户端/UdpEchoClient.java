package UDP.客户端;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient  {
    //构造，构造的时候需要传入要连接的服务器ip和端口
    //客户端的执行分四步
    //1、从用户读取输入数据
    //2、构造请求发送给服务器
    //3、从服务器读取响应
    //4、把响应写回给客户端
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    //构造的时候需要传入要连接的服务器ip和端口
    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();//构建客户端socket时不用绑定端口号
        //服务器必须绑定端口，客户端必须不绑定端口(由操作系统自动分配一个空闲端口）
        //如果客服端绑定，一个主机上就只能启动一个客户端了
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //1、读取用户输入的数据
            System.out.println("输入数据：");
            String request = scanner.nextLine();
            if(request.equals("退出")){
                break;
            }
            //2、构造请求发送给服务器
            //里面传入缓冲区，还有缓冲区长度，还有服务器ip 服务器端口号
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);//发送请求

            //3、从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            //response中放入请求
            String response = new String(responsePacket.getData(),0,
                    responsePacket.getLength()).trim();

            //4、显示响应数据
            System.out.println(response);

        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        //127.0.0.1表示环回ip，自己访问自己，刚刚所写的服务器和客户端都是在一个主机上，所以使用这个ip
        //如果不在同一个主机上，此处的ip就要写成要访问的服务器ip，9090就是上面写的服务器的端口号
        udpEchoClient.start();

    }

}
