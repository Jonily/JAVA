package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    //1、新增文章（发布博客）
    public void add(Article article){
        //1、获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2、构造SQL
        String sql = "insert into article values (null, ?, ?, ?))";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            statement.setString(3,article.getUserId());

            //3、执行SQL语句
            int ret = statement.executeUpdate();
            if(ret != 1){
                System.out.println("执行插入文章操作失败！");
                return;
            }
            System.out.println("执行插入文章操作成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4、释放连接
            DBUtil.close(connection,statement,null);
        }
    }


    //2、查看文章列表（把所有文章信息都查出来，不查正文）
    public List<Article> selectAll(){
        List<Article> articles = new ArrayList<>();
        //1、建立连接
        Connection connection = DBUtil.getConnection();
        //2、拼装SQL
        String sql = "select articleId, title, userId from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            //执行SQL
            resultSet = statement.executeQuery();
            //遍历结果集
            while (resultSet.next()){
                //针对每个结果记录，都构造一个对应的Article对象
                //此时由于没有从数据库中读content字段，这个字段暂时先不设置
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                articles.add(article);
            }

            return articles;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //3、查看指定文章详情(查看正文)
    public Article selectById(int articleId){
        //1、建立连接
        Connection connection = DBUtil.getConnection();
        //2、构造SQL
        String sql = "select * from article where articleId = ? ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            //3、执行SQL
            resultSet = statement.executeQuery();
            //4、遍历结果集合
            //由于id是主键，不会重复，预期只有一条记录
            if(resultSet.next()){
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5、释放连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //4、删除指定文章（给定文章ID删除）
    public void delete(int articleId){
        //1、获取连接
        Connection connection = DBUtil.getConnection();
        //2、拼装SQL
        String sql = "delete from article where article = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            //3、执行SQL
            int ret = statement.executeUpdate();
            if(ret != 1){
                System.out.println("删除文章失败！");
                return;
            }
            System.out.println("删除文章成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4、释放SQL
            DBUtil.close(connection,statement,null);
        }
    }
}
