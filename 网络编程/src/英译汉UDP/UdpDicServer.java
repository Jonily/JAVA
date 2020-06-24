package 英译汉UDP;

import UDP.服务器.UdpEchoServer;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDicServer extends UdpEchoServer {
    private Map<String,String> dict = new HashMap<>();

    public UdpDicServer(int port) throws SocketException {
        super(port);
        dict.put("cat","猫");
        dict.put("dog","狗");
        dict.put("bed","床");
        dict.put("water","水");
        dict.put("sun","太阳");
        dict.put("moon","月亮");

    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"超出词典范围");

    }

    public static void main(String[] args) throws IOException {
        UdpDicServer server = new UdpDicServer(9090);
        server.start();
    }
}
