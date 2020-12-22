import com.my.dao.BlogMapper;
import com.my.pojo.Blog;
import com.my.utils.IDUtils;
import com.my.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBook(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java");
        mapper.addBook(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring");
        mapper.addBook(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务");
        mapper.addBook(blog);

       // 因为在前面的连接中设置自动提交事务所以这里不用commit
        sqlSession.close();

    }

    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","微服务");
        //map.put("author","狂神");

        List<Blog> blogList = mapper.queryBlogIf(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("views",9999);
        map.put("author","狂神");
        map.put("title","微服务");


        List<Blog> blogList = mapper.queryBlogChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void   updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        //map.put("views",9999);
        map.put("author","狂");
        map.put("title","啦啦啦啦啦啦");
        map.put("id","d470a3a16ed048ce94b52b527ee4b762");


         mapper.updateBlog(map);

        sqlSession.close();
    }
    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        map.put("ids",ids);
        ids.add(1);
        ids.add(2);
        ids.add(4);


        List<Blog> blogList = mapper.queryBlogForeach(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

}
