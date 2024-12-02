import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linebead.mapper.StudentMapper;
import com.linebead.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月02日22:15
 */
public class MybatiesTest {

    private  SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        String  path="mybatis-config.xml";
        final InputStream resourceAsStream = Resources.getResourceAsStream(path);
        final SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
          sqlSession = build.openSession(true);

    }

    @Test
    public void test(){
        final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        PageHelper.startPage(1, 2);
        final List<Student> students = mapper.queryAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        System.out.println(pageInfo);

        long total = pageInfo.getTotal(); // 获取总记录数
        System.out.println("total = " + total);
        int pages = pageInfo.getPages();  // 获取总页数
        System.out.println("pages = " + pages);


    }

    @AfterEach
    public void after() {
        sqlSession.close();
    }
}
