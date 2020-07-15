package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                articles.add

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //3、查看指定文章详情

    //4、删除指定文章（给定文章ID删除）
}
