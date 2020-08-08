package model;

import java.sql.Timestamp;
import java.util.List;

//通过这个Order来表示一个完整的账单
//包括订单中都有哪些菜
//Order类对应到两张表 ：order_user 和 order_dish
public class Order {
    private int orderId;
    private int userId;
    private Timestamp time;//时间戳
    private int isDone;
    private List<Dish> dishList ;//一个订单中包含了很多菜

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}
