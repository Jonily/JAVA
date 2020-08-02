package DAO;

import DBUtil.DBUtils;
import entity.MV;
import entity.Music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MvDao {


    /**
     * 查询所有的MV
     */
    public List<MV> findMv(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MV> mvList = new ArrayList<>();

        String sql ="select * from mv";
        try{
            connection = DBUtils.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                MV mv = new MV();
                mv.setId(resultSet.getInt("id"));
                mv.setTitle(resultSet.getString("title"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setTime(resultSet.getDate("time"));
                mv.setUrl(resultSet.getString("url"));
                mv.setUserid(resultSet.getInt("userid"));
                mvList.add(mv);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,preparedStatement,resultSet);
        }

        return mvList;
    }

    /**2
     * 根据id查找mv
     */
    public MV findMvById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try{
            String sql ="select * from mv where id =?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){

               MV mv = new MV();
                mv.setId(resultSet.getInt("id"));
                mv.setTitle(resultSet.getString("title"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setTime(resultSet.getDate("time"));
                mv.setUrl(resultSet.getString("url"));
                mv.setUserid(resultSet.getInt("userid"));
                return mv;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return null;
    }


    /**
     * 根据关键字查找MV
     */

    public List<MV> findMvByStr(String s){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MV> mvList = new ArrayList<>();

        String sql = "select * from mv where title like '%" + s + "%'";
        try{
            connection = DBUtils.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MV mv = new MV();
                mv.setId(resultSet.getInt("id"));
                mv.setTitle(resultSet.getString("title"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setTime(resultSet.getDate("time"));
                mv.setUrl(resultSet.getString("url"));
                mv.setUserid(resultSet.getInt("userid"));
                mvList.add(mv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,preparedStatement,resultSet);
        }
        return mvList;
    }



    /**
     * 上传MV可以直接传入一个MV对象
     * 先把文件给服务器
     * 之后给数据库
     * 下面就是将文件放到数据库中
     */
    public int Insert(String title, String singer, String time, String url,
                      int userid) {
        Connection connection = null;
        PreparedStatement statement = null;
        int num = 0;
        try{
            String sql = "insert into mv(title,singer,time,url,userid) values(?,?,?,?,?)";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setString(1,title);
            statement.setString(2,singer);
            statement.setString(3,time);
            statement.setString(4,url);
            statement.setInt(5,userid);

            num = statement.executeUpdate();//影响的行数。

            if (num == 1){
                return 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement, null);
        }
        return 0;
    }



    /**
     * 通过ID删除mv
     */

    /**5
     * 通过ID删除歌曲
     */
    public int deleteMvById(int id){
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            String sql = "delete from  mv where id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int ret = statement.executeUpdate();

            if(ret == 1){
                //同时删除中间表中的数据
                //1、看中间表中是否有数据，如有那就删除
                if(findLoveMvById(id)){
                    int ret2 = removeLoveMvDelete(id);
                    if(ret2 == 1){
                        return 1;
                    }
                }else {
                    //如果没有找到，说明这首歌没有，被添加到喜欢的列表
                    return 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,null);
        }
        return 0;
    }

    /**
     * 查看中间表是否有该IDmv
     */
    public boolean findLoveMvById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "select * from lovemv where mv_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return false;
    }

    /**
     *删除服务器上的音乐时，同时在我喜欢的列表的数据库中进行删除
     */
    public int removeLoveMvDelete(int mvId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            String sql = "delete  from  lovemv where mv_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,mvId);
            int ret = statement.executeUpdate();
            if(ret == 1){
                return ret;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,null);
        }
        return 0;
    }


    /**
     *添加喜欢的mv的时候，需要先判断该mv是否存在
     * mvId
     */
    public boolean findLoveMvByMvId(int userId,int mvId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from lovemv where user_id=? and mv_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(2,mvId);

            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return false;
    }


    /**
     * 添加mv到“喜欢”列表中
     * 用户-》mv
     * 多对多
     * 需要中间表
     */
    public boolean insertLoveMv(int userId,int mvId){
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            String sql = "insert into lovemv (user_id,mv_id) values (?,?)";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(2,mvId);

            int ret = statement.executeUpdate();
            if(ret == 1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,null);
        }
        return false;
    }
    /**
     * 移除喜欢的mv
     * userId 用户id
     * mvId mvid
     * 返回受影响的行数
     * 移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢
     */
    public int removeLoveMv(int userId,int mvId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "delete from lovemv where user_id=? and mv_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(2,mvId);

            int ret = statement.executeUpdate();
            if(ret == 1){
                return ret;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,null);
        }
        return 0;
    }

    /**
     * 查询用户喜欢的全部mv
     * user_id
     * @return
     */
    public List<MV> findLoveMvByUserId(int userId){
        List<MV> mvList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "select mv.id as mv_id,title,singer,time,url,userid from "+
                    "lovemv lovemv,mv mv where lovemv.mv_id=mv.id and user_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                MV mv = new MV();
                mv.setId(resultSet.getInt("mv_id"));
                mv.setTitle(resultSet.getString("title"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setTime(resultSet.getDate("time"));
                mv.setUrl(resultSet.getString("url"));
                mv.setUserid(resultSet.getInt("userid"));

                mvList.add(mv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return mvList;
    }

    /**
     * 根据关键字查询喜欢的mv
     * @param str
     * @return
     */
    public  List<MV> ifMvLove(String str,int user_id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<MV> musicList = new ArrayList<>();

        try {
            String sql = "select m.id as mv_id,title,singer,time,url,userid from lovemv lm,mv m " +
                    "where lovemv.mv_id=m.id and user_id=? and title like '%"+str+"%'";
            connection = DBUtils.getConnect();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                MV mv = new MV();
                mv.setId(rs.getInt("mv_id"));
                mv.setTitle(rs.getString("title"));
                mv.setSinger(rs.getString("singer"));
                mv.setTime(rs.getDate("time"));
                mv.setUrl(rs.getString("url"));
                mv.setUserid(rs.getInt("userid"));
                musicList.add(mv);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return musicList;
    }

    public static void main(String[] args) {
      /*  //  System.out.println(findMusicByStr("羊"));
        //insertLoveMusic(1,2);
       *//* List<Music> musicList = findLoveMusicByUserId(1);
        System.out.println(musicList);*//*
       *//*Music music =  findMusicById(1);
        System.out.println(music);*//*
        MvDao mvDao = new MvDao();
         mvDao.Insert("白羊","徐秉龙","2020-07-24","music\\白羊",1);
         MV mv = mvDao.findMvById(1);
        System.out.println(mv);
        List<MV> list = mvDao.findLoveMvByUserId(1);
        System.out.println(list);
        mvDao.insertLoveMv(1,1);*/
    }


}
