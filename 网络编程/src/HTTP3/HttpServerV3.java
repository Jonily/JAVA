package HTTP3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    private ServerSocket serverSocket = null;

    public HttpServerV3(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    public void process(Socket clientSocket) {
        // 处理核心逻辑
        try {
            // 1. 读取请求并解析
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            // 2. 根据请求计算响应
            // 此处按照不同的 HTTP 方法, 拆分成多个不同的逻辑
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                doGet(request, response);
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                doPost(request, response);
            } else {
                // 其他方法, 返回一个 405 这样的状态码
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
            // 3. 把响应写回到客户端
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        // 1. 能够支持返回一个 html 文件.
        if (request.getUrl().startsWith("/index.html")) {
            // 这种情况下, 就让代码读取一个 index.html 这样的文件.
            // 要想读文件, 需要先知道文件路径. 而现在只知道一个 文件名 index.html
            // 此时这个 html 文件所属的路径, 可以自己来约定(约定某个 d:/...) 专门放 html .
            // 把文件内容写入到响应的 body 中
            InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // 按行读取内容, 把数据写入到 response 中
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                response.writeBody(line + "\n");
            }
            bufferedReader.close();
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        // 2. 实现 /login 的处理
        if (request.getUrl().startsWith("/login")) {
            // 读取用户提交的用户名和密码
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("userName: " + userName);
            System.out.println("password: " + password);
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 serverV3 = new HttpServerV3(9090);
        serverV3.start();
    }
}
