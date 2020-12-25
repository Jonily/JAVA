
import com.my.dao.UserMapper;

import com.my.pojo.User;

import com.my.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;


public class MyTest {
    @Test
    public void queryUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(2);
        System.out.println(user);
        sqlSession.close();

        System.out.println("====================================");

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(2);
        System.out.println(user2);

        System.out.println(user==user2);
        // 因为在前面的连接中设置自动提交事务所以这里不用commit
        sqlSession2.close();
    }
     /*     //mapper.updateUser(new User(3,"llll","1234654646"));

        sqlSession.clearCache();//手动清理
*/



}
