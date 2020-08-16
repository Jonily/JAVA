package API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static  class Response{
        public int ok;
        public String reason;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Response response = new Response();
        try {
            //1、根据sessionId找对应的session对象
            HttpSession httpSession = req.getSession(false);
            if(httpSession == null){
                throw new OrderSystemException("您尚未登陆！");
            }
            //2、把session对象中存的user信息删除（直接删掉session中的键值对也可以）

            //如果是想删除session键值对本身就要设置一个过期时间，让session立刻过期

            httpSession.removeAttribute("user");
            response.ok=1;
            response.reason="";

        } catch (OrderSystemException e) {
            response.ok=0;
            response.reason=e.getMessage();

        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);

        }

    }
}
