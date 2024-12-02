import com.linebead.mapper.EmployeeMapper;
import com.linebead.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月01日23:39
 */
public class MyBatisTest {
    @Test
    public void test() throws IOException {

        String  path="mybatis-config.xml";

        final InputStream resourceAsStream = Resources.getResourceAsStream(path);

        final SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        final SqlSession sqlSession = build.openSession();
        final EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        Map<String, Object> resultMap=   mapper.selectEmpNameAndMaxSalary();
//
//        System.out.println(resultMap);

      List<Employee> list=  mapper.queryAllEmp();
        System.out.println("结果"+list);
        sqlSession.commit();
        sqlSession.close();


    }
}
