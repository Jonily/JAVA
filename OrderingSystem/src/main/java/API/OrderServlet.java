package API;

import DAO.OrderDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.fabric.Response;
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
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        try {
            // 1. 检查用户登陆状态.
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登陆");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登陆");
            }
            // 2. 判断用户是否是管理员
            if (user.getIsAdmin() == 1) {
                // 管理员, 就禁止新增订单
                throw new OrderSystemException("您是管理员不能添加！");
            }
            // 3. 读取 body 中的数据, 进行解析.
            String body = OrderSystemUtil.readBody(req);
            // 4. 按照 JSON 格式解析 body
            Integer[] dishIds = gson.fromJson(body, Integer[].class);
//            List<Integer> dishIds = gson.fromJson(body, new TypeToken<List<Integer>>() {}.getType());
            // 5. 构造订单对象, 此处 orderId, time, isDone, Dish 中的 name, price 这些都不需要填充
            //    不影响订单插入.
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> dishes = new ArrayList<>();
            for (Integer dishId : dishIds) {
                Dish dish = new Dish();
                dish.setDishId(dishId);
                dishes.add(dish);
            }
            order.setDishList(dishes);
            // 6. 把 Order 对象插入到数据库中
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }


    //查看所有订单
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Response response = new Response();
        try {
            //1、验证用户登陆状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登陆");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登陆");
            }
            //2、判断用户是管理还普通用户
            //3、读取orderId字段，看该字段是否存在
            String orderIds =req.getParameter("orderId");
            OrderDao orderDao = new OrderDao();

            if(orderIds == null){
                //4、查找数据库
                List<Order> orderList = null;
                if(user.getIsAdmin() == 0){
                    //普通用户只能看自己的订单
                    orderList = orderDao.selectByUserId(user.getUserId());

                }else {
                    //管理员查看所有订单
                    orderList = orderDao.selectAll();

                }
                //4、构造响应
                String jsonString = gson.toJson(orderList);
                resp.getWriter().write(jsonString);
            }else {

                //4、查找指定订单
                int orderId = Integer.parseInt(orderIds);
                Order order = orderDao.selectById(orderId);

                //如果是普通用户，查找时发现自身的userId和订单的userId不同
                //这种就返回一个出数据  如果是管理员才能看到所有用户的订单

                if(user.getIsAdmin() == 0 &&
                        order.getUserId() != user.getUserId()){
                    throw new OrderSystemException("当年您无权查看其他人的订单");

                }
                String jsonString = gson.toJson(order);
                resp.getWriter().write(jsonString);

            }

        } catch (OrderSystemException e) {
            //5、异常处理
            response.ok = 0;
            response.reason=e.getMessage();
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }


    //修改订单状态
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        try {
            // 1. 检查用户登陆状态.
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登陆");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登陆");
            }
            // 2. 判断用户是否是管理员
            if (user.getIsAdmin() == 0) {
                // 管理员, 就禁止新增订单
                throw new OrderSystemException("您不是管理员不能修改！");
            }
            // 3. 读取请求中的orderId 和 idDone.
            String orderIdstr = req.getParameter("orderId");
            String isDoneStr = req.getParameter("isDone");
            if(orderIdstr == null || isDoneStr == null){
                throw new OrderSystemException("参数有误！");

            }
            // 4. 修改数据库
             OrderDao orderDao = new OrderDao();
            int orderId = Integer.parseInt(orderIdstr);
            int isDone = Integer.parseInt(isDoneStr);
            orderDao.changeState(orderId,isDone);
            // 5. 返回响应
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
