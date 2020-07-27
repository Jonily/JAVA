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
    /**1
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

    /**2
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

    /**3
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

    /**4
     * 上传音乐可以直接传入一个Music对象
     * 先把文件给服务器
     * 之后给数据库
     * 下面就是将文件放到数据库中
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


    /**5
     * 通过ID删除歌曲
     */
    public int deleteMusicById(int id){
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            String sql = "delete from  music where id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int ret = statement.executeUpdate();

            if(ret == 1){
                //同时删除中间表中的数据
                //1、看中间表中是否有数据，如有那就删除
                if(findLoveMusicById(id)){
                   int ret2 = removeLoveMusicDelete(id);
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

    /**6
     * 查看中间表是否有该ID歌曲
     */
    private boolean findLoveMusicById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "select * from lovemusic where music_id=?";
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

    /**7
     *删除服务器上的音乐时，同时在我喜欢的列表的数据库中进行删除
     */
    private int removeLoveMusicDelete(int musicId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            String sql = "delete  from  lovemusic where music_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,musicId);
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

    /**8
     * 添加音乐到“喜欢”列表中
     * 用户-》音乐
     * 多对多
     * 需要中间表
     */
    public static boolean insertLoveMusic(int userId,int musicId){
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            String sql = "insert into lovemusic (user_id,music_id) values (?,?)";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(2,musicId);

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

    /**9
     * 移除喜欢的音乐
     * userId 用户id
     * musicId 歌曲id
     * 返回受影响的行数
     * 移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢
     */
    public int removeLoveMusic(int userId,int musicId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "delete from lovemusic where user_id=? and music_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(2,musicId);

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

    /**10
     *添加喜欢的音乐的时候，需要先判断该音乐是否存在
     * musicId
     */
    public boolean findMusicByMusicId(int userId,int musicId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from lovemusic where user_id=? and music_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(2,musicId);

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


    /**11
     * 查询用户喜欢的全部歌单
     * user_id
     * @return
     */
    public static List<Music> findLoveMusicByUserId(int userId){
        List<Music> musicList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "select music.id as music_id,title,singer,time,url,userid from "+
           "lovemusic lovemusic,music music where lovemusic.music_id=music.id and user_id=?";
            connection = DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Music music = new Music();
                music.setId(resultSet.getInt("music_id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getDate("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserid(resultSet.getInt("userid"));

                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return musicList;
    }

    /**
     * 根据关键字查询喜欢的歌单
     * @return
     */
    public List<Music> ifMusicLove(String str,int userId){
        List<Music> musicList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql ="select music.id as music_id,title,singer,time,url,userid from" +
                    "lovemusic lovemusic.music,music music " +
                    "where lovemusic.music_id = music.id and user_id=? and title like'%s"+str+"'";
            connection =DBUtils.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Music music = new Music();
                music.setId(resultSet.getInt("music_id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getDate("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserid(resultSet.getInt("userid"));

                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return musicList;
    }



    public static void main(String[] args) {
        //insertLoveMusic(1,2);
        List<Music> musicList = findLoveMusicByUserId(1);
        System.out.println(musicList);
       /*Music music =  findMusicById(1);
        System.out.println(music);*/
    /*    Insert("白羊","徐秉龙","2020-07-24","music\\白羊",1);*/
    }


}
