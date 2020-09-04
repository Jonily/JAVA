package DAO;

import EXception.riverException;
import Util.DBUtil;
import model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class riverMaking {
    public void addRiver(River river) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;



        String sql ="insert into river values (null,?,?,?,?,?)";
        connection= DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,river.getRiver_name());
            preparedStatement.setString(2,river.getRiver_length());
            preparedStatement.setString(3,river.getRiver_location());
            preparedStatement.setString(4,river.getRiver_class());
            preparedStatement.setString(5,river.getRiver_status());

            int ret = preparedStatement.executeUpdate();

            if(ret!= 1){
                throw new riverException("插入数据失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("插入数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    public void deleteRiverByNum(int num) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "delete from river where river_num = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("删除数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("删除数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    public void deleteRiverByName(String name) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "delete from river where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("删除数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("删除数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    public List<River> SelectAll() throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from river ";
        connection = DBUtil.getConnect();

        List<River> riverList = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                River river = new River() ;
                river.setRiver_num(resultSet.getInt("river_num"));
                river.setRiver_name(resultSet.getString("river_name"));
                river.setRiver_length(resultSet.getString("river_length"));
                river.setRiver_location(resultSet.getString("river_location"));
                river.setRiver_class(resultSet.getString("river_class"));
                river.setRiver_status(resultSet.getString("river_status"));
                riverList.add(river);


            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("查询所有河流信息失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return riverList;

    }

    public River selectByNum(int num) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from dishes where river_num = ?";
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                River river = new River() ;
                river.setRiver_num(resultSet.getInt("river_num"));
                river.setRiver_name(resultSet.getString("river_name"));
                river.setRiver_length(resultSet.getString("river_length"));
                river.setRiver_location(resultSet.getString("river_location"));
                river.setRiver_class(resultSet.getString("river_class"));
                river.setRiver_status(resultSet.getString("river_status"));
                return  river;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("按照num查找河流失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }


    public River selectByName(String name) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from dishes where river_namw = ?";
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                River river = new River() ;
                river.setRiver_num(resultSet.getInt("river_num"));
                river.setRiver_name(resultSet.getString("river_name"));
                river.setRiver_length(resultSet.getString("river_length"));
                river.setRiver_location(resultSet.getString("river_location"));
                river.setRiver_class(resultSet.getString("river_class"));
                river.setRiver_status(resultSet.getString("river_status"));
                return  river;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("按照名字查找河流失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }


    public void updateRiverLocationByName(String name, String location) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_location = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,location);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    public void updateRiverLengthByName(String name, String length) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_length = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,length);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    public void updateRiverClassByName(String name, String riverClass) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_class = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,riverClass);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }


    public void updateRiverStatusByName(String name, String status) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_status = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,status);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }



}
