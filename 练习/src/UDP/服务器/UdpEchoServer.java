package UDP.服务器;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //1、进行初始化，实例化Socket对象
    //2、进入主循环（死循环，一直接受请求）
    //a、读取数据并解析
    //b、根据请求计算响应
    //c、把结果写回到客户端
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        //new这个Socket对象就会让当前的socket对象和一个ip地址以及一个端口号关联（绑定端口）
        //未来客户端就按照这个ip+端口访问服务器
        //如果在构造socket的时候没写ip默认是0.0.0.0（特殊ip会关联到这个主机的所有网卡）
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //a. 读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);//udp发送接收数据基本单位
           //实例化中传入一个缓冲区
            //socket对象本质上是一个文件，文件是网卡的抽象
            socket.receive(requestPacket);//程序启动马上执行receive，读取从客户端收到的请求
            //receive被堵塞，知道真的有数据来，receive就会把数据放入到刚刚new的缓冲区当中

            //把收到的请求数据转成一个String（本来是一个byte[]），用trim（）是为了去掉数组中的空白部分，提高效率
            String request = new String(requestPacket.getData(),
                    0,requestPacket.getLength()).trim();

            //b。根据请求计算响应
            String response = process(request);

            //c。把响应传回给客户端,传回的相应就是response变量,需要包装成Packet对象传回
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            //利用String中的getBytes()方法把response构造成Packet对象，之后是数据的长度，
            // 还有包要发送给谁，requestPacket.getSocketAddress()，获取客户端地址
            //此处的地址就是客户端的地址和端口，这两个信息就包含在requePacket内部
            //response.getBytes().length是字节数、response.getBytes().length（）是字符数
            socket.send(responsePacket);


            //方便观察打印日志
            System.out.printf("[%s:%d] 目的IP :%s; 目的端口号: %s\n",requestPacket.getAddress().toString(),
                   requestPacket.getPort(),request,response );
        }
    }
    public String process (String s){
        //因为是echo server回显服务器，所以process方法只要接收然后直接返回就行，不需要其他操作
        //如果更复杂，在这个方法里面可以包含更多的其他操作
        return s;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);//指定一个端口号
        udpEchoServer.start();
    }
}
