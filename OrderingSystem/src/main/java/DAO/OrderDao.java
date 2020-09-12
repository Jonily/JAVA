package DAO;
//操作订单
// 1.新增订单
// 2.查看所有订单(管理员、商家)
// 3.查看指定用户的订单（用户、商家）
// 4.查看订单的详细信息
// 5.修改订单状态(订单是否已经完成)


import model.DBUtil;
import model.Dish;
import model.Order;
import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    //新增订单
    //订单是和两个表关联的。
//第一个表order_ user
//第二个表order_ dish, 一个订单中可能会涉及点多个菜，就需要给这个表次性插入多 个记录。



    public void add(Order order) throws OrderSystemException {
        // 1. 先操作 order_user 表
        addOrderUser(order);
        // 2. 再操作 order_dish 表
        //    执行 add 方法的时候, order 对象中的 orderId 字段还是空着的呢~~
        //    这个字段要交给数据库, 由自增主键来决定.
        addOrderDish(order);
    }

    public void addOrderUser(Order order) throws OrderSystemException {
        // 1. 先获取到数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 构造 SQL
        String sql = "insert into order_user values(null, ?, now(), 0)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 加上 RETURN_GENERATED_KEYS 选项, 插入的同时就会把数据库自动生成的自增主键的值获取到
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getUserId());
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("插入订单失败");
            }
            // 把自增主键的值给读取出来.
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                // 理解参数 1. 读取 resultSet 的结果时, 可以使用列名, 也可以使用下标.
                // 由于一个表中的自增列可以有多个. 返回的时候都返回回来了. 下标填成 1
                // 就表示想获取到第一个自增列生成的值.
                order.setOrderId(resultSet.getInt(1));
            }
            System.out.println("插入订单第一步成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入订单失败");
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
    }

    // 把菜品信息给插入到表 order_dish 中.
    public void addOrderDish(Order order) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL 语句
        String sql = "insert into order_dish values(?, ?)";
        PreparedStatement statement = null;
        try {
            // 3. 关闭自动提交
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            // 由于一个订单对应到多个菜品, 就需要遍历 Order 中包含的菜品数组, 把每个记录都取出来
            // 4. 遍历 dishes 给 SQL 添加多个 values 的值
            List<Dish> dishes = order.getDishes();
            for (Dish dish : dishes)  {
                // OrderId 是在刚刚进行插入 order_user 表的时候, 获取到的自增主键
                statement.setInt(1, order.getOrderId());
                statement.setInt(2, dish.getDishId());
                statement.addBatch(); // 给 sql 新增一个片段.
            }
            // 5. 执行 SQL (并不是真的执行)
            statement.executeBatch(); // 把刚才的 sql 进行执行.
            // 6. 发送给服务器 (真的执行), commit 可以去执行多个 SQL, 一次调用 commit 统一发给服务器.
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // 如果上面的操作出现异常, 就认为整体的新增订单操作失败, 回滚之前的插入 order_user 表的内容
            deleteOrder(order.getOrderId());
        } finally {
            // 关闭数据库连接
            DBUtil.close(connection, statement, null);
        }
    }

    // 这个方法用于删除 order 表中的记录.
    public void delete(int orderId) throws OrderSystemException {

        deleteOrderDish(orderId);
        deleteOrder(orderId);

    }
    public void deleteOrder(int orderId) throws OrderSystemException {
        // 1. 获取数据库连接

        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "delete from order_user where orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("回滚失败");
        } finally {
            DBUtil.close(connection, statement, null);
        }

    }

    //方法用于删除菜
    public void deleteOrderDish(int orderId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from order_dish where orderId = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderId);
            int ret = preparedStatement.executeUpdate();

        /*    if (ret == 0) {
                throw new OrderSystemException("删除失败");
            }*/
            System.out.println("删除成功");
                } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }

    //查找所有订单
    //order对象中，有一些orderId userId 这些属性 直接借助order_user表就获取到dishes属性（List）
    //详细信息需要先根据order_dish表 获取到所有相关的dishId，然后根据dishId
    //去dishes表中查
    //仔细思考，可以发现，这里的订单获取，不需要获取那么详细的内容，只获取到订单的一些基本信息就行了。
//菜品信息，反正有一个查看指定订单详细信息的接口
    //当前这个接口返回的Order 对象中，不包含dishes 详细数据的.
//这样做是为了让代码更简单，更高效.




    public List<Order> selectAll(){
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from order_user";

        connection = DBUtil.getConnection();
        try {


            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //order对象中 没有dishes字段
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return orderList;

    }


    //通过用户id查找订单
    public List<Order> selectByUserId(int userId){
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from order_user where userId = ?";

        connection = DBUtil.getConnection();
        try {


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //order对象中 没有dishes字段
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return orderList;

    }

    //查看指定订单的详细信息
    //把order对象完整的填写进去 包括Order中有哪些菜品 菜品详情
    public Order selectById(int orderId) throws OrderSystemException {
        // 1.先根据orderId得到一个Order对象
        Order order = buildOrder(orderId);
// 2.根据orderId 得到该orderId 对应的菜品id列表
        List<Integer> dishIds = selectDishIds(orderId);

//3.根据菜品id列表，查询dishes表，获取到菜品详情
        order = getDishDetail(order,dishIds);
        return order;


    }



    //根据orderid查对应Order对象基本信息
    //查找order_user表
    public Order buildOrder(int orderId) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from order_user where orderId = ?";

        connection = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                //order对象中 没有dishes字段
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                return order;

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;

    }

       //查找order_dish
    public List<Integer> selectDishIds(int orderId) {
        List<Integer> dishIds = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from order_dish where orderId = ?";

        connection = DBUtil.getConnection();
        try {


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                dishIds.add(resultSet.getInt("dishId"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return dishIds;

    }

   /* //查找order_dish
    public List<Integer> selectDish(int userId) {
        List<Integer> dishIds = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from order_dish where orderId = (select orderId from order_user where userId = ?)";

        connection = DBUtil.getConnection();
        try {


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                dishIds.add(resultSet.getInt("dishId"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return dishIds;

    }*/



    public Order getDishDetail(Order order, List<Integer> dishIds) throws OrderSystemException {
        //准备好要返回的结果
        List<Dish> dishList = new ArrayList<>();
        //2、遍历dishIds 再dishes表中 查
        DishDao dishDao = new DishDao();
        for (Integer dishId: dishIds) {
            Dish dish = dishDao.selectById(dishId);
            dishList.add(dish);
        }
        //3、把dishList设置到 order 对象中
        order.setDishes(dishList);
        return order;
    }



    //修改订单状态
    public void changeState(int orderId,int isDone) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql ="update order_user set isDone = ? where orderId =?";

        connection = DBUtil.getConnection();
        try {

            //获取自增主键的值
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2,orderId);
            preparedStatement.setInt(1,isDone);

            int ret = preparedStatement.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("修改失败！");
            }

            System.out.println("修改成功！");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改失败！");

        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }

    }

 /*   public static void main(String[] args) throws OrderSystemException {
        OrderDao orderDao = new OrderDao();
        Order order = new Order();

        orderDao.selectDish(3);
    }
*/

}
