package DAO;

import model.DBUtil;
import model.Dish;
import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//操作菜品表
//1、新增菜品
//2、删除菜品
//3、查询所有菜品
//4、查询指定菜品
//修改菜品
public class DishDao {

    public void Add(Dish dish ) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="insert into dishes values (null,?,?)";
        connection = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,dish.getName());
            preparedStatement.setInt(2,dish.getPrice());

            int ret = preparedStatement.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("插入菜品失败！");

            }
            System.out.println("插入菜品成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入菜品失败！");
        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }

    public void Delete(int dishId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="delete from dishes where dishId = ?";
        connection = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dishId);
            int ret = preparedStatement.executeUpdate();

            if(ret != 1){
                throw new OrderSystemException("删除菜品失败！");

            }
            System.out.println("删除菜品成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除菜品失败！");
        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }

    }

    public List<Dish> SelectAll() throws OrderSystemException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from dishes ";
        connection = DBUtil.getConnection();

        List<Dish> dishList = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));

                dishList.add(dish);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查询所有菜品失败！");

        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return dishList;

    }

    public Dish selectById(int dishId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from dishes where dishId = ?";
        connection = DBUtil.getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dishId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                return dish;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按照id查找菜品失败！");

        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

   /* public static void main(String[] args) throws OrderSystemException {
        DishDao dishDao = new DishDao();
        Dish dish = new Dish();
        *//*dish.setName("hrs");
        dish.setPrice(1225);
        dishDao.Add(dish);*//*
        System.out.println(dishDao.selectById(2));
        System.out.println(dishDao.SelectAll());
    }*/
}
