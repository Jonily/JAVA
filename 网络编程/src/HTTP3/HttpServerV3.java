package HTTP3;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    static class User {
        // 保存用户的相关信息
        public String userName;
        public int age;
        public String school;
    }

    private ServerSocket serverSocket = null;
    // session 会话. 指的就是同一个用户的一组访问服务器的操作, 归类到一起, 就是一个会话.
    // 记者来采访你, 记者问的问题就是一个请求, 你回答的内容, 就是一个响应. 一次采访过程中
    // 涉及到很多问题和回答(请求和响应), 这一组问题和回答, 就可以称为是一个 "会话" (整个采访的过程)
    // sessions 中就包含很多会话. (每个键值对就是一个会话)
    private HashMap<String, User> sessions = new HashMap<>();

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
        } catch (IOException | NullPointerException e) {
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
            String sessionId = request.getCookie("sessionId");
            User user = sessions.get(sessionId);
            if (sessionId == null || user == null) {
                // 说明当前用户尚未登陆, 就返回一个登陆页面即可.

                // 这种情况下, 就让代码读取一个 index.html 这样的文件.
                // 要想读文件, 需要先知道文件路径. 而现在只知道一个 文件名 index.html
                // 此时这个 html 文件所属的路径, 可以自己来约定(约定某个 d:/...) 专门放 html .
                // 把文件内容写入到响应的 body 中
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                // 按行读取内容, 把数据写入到 response 中
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    response.writeBody(line + "\n");
                }
                bufferedReader.close();
            } else {
                // 用户已经登陆, 无需再登陆了.
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>" + "您已经登陆了! 无需再次登陆! 用户名: " + user.userName + "</div>");
                response.writeBody(+ user.age + "</div>");
                response.writeBody("<div>" + user.school + "</div>");
                response.writeBody("</html>");
            }
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        // 2. 实现 /login 的处理
        if (request.getUrl().startsWith("/login")) {
            // 读取用户提交的用户名和密码
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
//            System.out.println("userName: " + userName);
//            System.out.println("password: " + password);
            // 登陆逻辑就需要验证用户名密码是否正确.
            // 此处为了简单, 咱们把用户名和密码在代码中写死了.
            // 更科学的处理方式, 应该是从数据库中读取用户名对应的密码, 校验密码是否一致.
            if ("tz".equals(userName) && "123".equals(password)) {
                // 登陆成功
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                // 原来登陆成功, 是给浏览器写了一个 cookie, cookie 中保存的是用户的用户名.
                // response.setHeader("Set-Cookie", "userName=" + userName);

                // 现有的对于登陆成功的处理. 给这次登陆的用户分配了一个 session
                // (在 hash 中新增了一个键值对), key 是随机生成的. value 就是用户的身份信息
                // 身份信息保存在服务器中, 此时也就不再有泄露的问题了
                // 给浏览器返回的 Cookie 中只需要包含 sessionId 即可
                String sessionId = UUID.randomUUID().toString();
                User user = new User();
                user.userName = "tz";
                user.age = 20;
                user.school = "陕科大";
                sessions.put(sessionId, user);
                response.setHeader("Set-Cookie", "sessionId=" + sessionId);

                response.writeBody("<html>");
                response.writeBody("<div>欢迎您! " + userName + "</div>");
                response.writeBody("</html>");
            } else {
                // 登陆失败
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>登陆失败</div>");
                response.writeBody("</html>");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 serverV3 = new HttpServerV3(9090);
        serverV3.start();
    }
}
