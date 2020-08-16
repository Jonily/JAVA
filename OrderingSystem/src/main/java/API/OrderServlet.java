package API;

import DAO.OrderDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.Order;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    //这个类代表订单的相关操作
    //只有第一个有body 新增订单
    //body是数组 不需要专门创建一个类表示body内容
    static class Response{
        public int ok;
        public String reason;

    }


    //新增订单 只有普通用户可以

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();

        try {
            //1、判断登录状态
            HttpSession session = req.getSession(false);
            if(session == null){
                throw new OrderSystemException("您尚未登陆！");
            }
            User user = (User) session.getAttribute("user");
            if(user == null){
                throw new OrderSystemException("您尚未登陆！");
            }

            //2、判断是否是管理员 管理员不能新增订单
            if(user.getIsAdmin() == 1){
                //管理员禁止新增
                throw new OrderSystemException("您是管理不能新增！");
            }

            //3、读取body中的数据，进行解析
            String body = OrderSystemUtil.readBody(req);
            //4、按照json格式解析body
            Integer[] dishIds = gson.fromJson(body,Integer[].class);
            //如果要转回成一个整型数组
            //转换成list
            //List<Integer> dishIds = gson.fromJson(body,new TypeToken<List<Integer>>() {}.getType());
            //匿名内部类 此时必须借助TypeToken才可以正确获取到List的类型.
/*
                        Java泛型机制埋”下的隐患.
                    所谓的"泛型" ,在底层存储的就是Object.
                    泛型只是帮助用户自动的完成了类型转换和校验.
                    当程序被编译成字节码的时候，已经没有泛型信息了.此时如果直接List<Integer> .class得不到预期的结果的.
                    字节码中没有这个结构
*/

            //5、构造订单对象
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> dishList = new ArrayList<>();
            for (Integer dishId: dishIds) {
                Dish dish = new Dish();
                dish.setDishId(dishId);
                dishList.add(dish);
            }
            order.setDishList(dishList);
            //6、把order对象插入数据库中
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
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
