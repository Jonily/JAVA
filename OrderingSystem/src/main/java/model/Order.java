package model;

import java.sql.Timestamp;
import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private Timestamp time;
    private int isDone;
    private List<Dish> dishList ;//一个订单中包含了很多菜
}
