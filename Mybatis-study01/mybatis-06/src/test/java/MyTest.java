import com.my.dao.StudentMapper;
import com.my.dao.TeacherMapper;
import com.my.pojo.Student;
import com.my.pojo.Teacher;
import com.my.utils.MybatisUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);

        }
        sqlSession.close();

    }
    @Test
    public void testStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);

        }
        sqlSession.close();

    }


}
