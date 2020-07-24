package DAO;

import DBUtil.DBUtils;
import entity.Music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    /**
     * 查询全部歌单
     */
    public static List<Music> findMusic(){

        List<Music> musics = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql ="select * from  music";
             connection = DBUtils.getConnect();
             statement = connection.prepareStatement(sql);
             resultSet = statement.executeQuery();
             while (resultSet.next()){
                 Music music = new Music();
                 music.setId(resultSet.getInt("id"));
                 music.setTitle(resultSet.getString("title"));
                 music.setSinger(resultSet.getString("singer"));
                 music.setTime(resultSet.getDate("time"));
                 music.setUrl(resultSet.getString("url"));
                 music.setUserid(resultSet.getInt("userid"));
                 musics.add(music);
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return musics;
    }

    /**
     * 根据id查找音乐
     */
    public static Music findMusicById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Music music = null;
        try{
            String sql ="select * from music where id =?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){

                music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getDate("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserid(resultSet.getInt("userid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return music;

    }

    /**
     * 根据关键字查找音乐歌单
     */

    public static List<Music> findMusicByStr(String s){

        List<Music> musics = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql ="select * from  music where title like '%" + s + "%'";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getDate("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserid(resultSet.getInt("userid"));
                musics.add(music);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return musics;
    }

    /**
     * 上传音乐可以直接传入一个Music对象
     * 先把文件给服务器
     * 之后给数据库一下就是将文件放到数据库中
     */
    public static int Insert(String title, String singer, String time, String url,
                      int userid) {
        Connection connection = null;
        PreparedStatement statement = null;
        int num = 0;
        try{
            String sql = "insert into music(title,singer,time,url,userid) values(?,?,?,?,?)";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setString(1,title);
            statement.setString(2,time);
            statement.setString(3,singer);
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

    
    public static void main(String[] args) {
       /* List<Music> musicList = findMusicByStr("南");
        System.out.println(musicList);*/
       /*Music music =  findMusicById(1);
        System.out.println(music);*/
    /*    Insert("白羊","徐秉龙","2020-07-24","music\\白羊",1);*/
    }


}
