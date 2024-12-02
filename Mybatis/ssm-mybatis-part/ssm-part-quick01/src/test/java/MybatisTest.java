import com.linebead.mapper.EmployeeMapper;
import com.linebead.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年11月29日12:42
 */
public class MybatisTest {

    @Test
    public void test(){

        /*1、读mybatis的配置文件*/
        String path="mybatis-config.xml";


        try {

            /*1、以输入流的方式加载Mybatis的配置文件*/
             InputStream resourceAsStream = Resources.getResourceAsStream(path);

             /*2、基于读取Mybatis配置文件的输入流创建sqlSectionFactory对象*/
             SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

             /*3、使用sqlSessionFactory对象创建sqlSection*/
             SqlSession sqlSession = sqlSessionFactory.openSession();
             /*4.获取接口的代理对象，根据employeeMapper接口的class对象获取mapper接口类型的对象*/
             EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
             /*5、调用代理类方法就可以触发对应的sql语句*/
            Employee employee=new Employee();
//            String  id= UUID.randomUUID().toString();
//            System.out.println("主键"+id);
//            employee.setEmpId(7);
            employee.setEmpName("张三");
            employee.setEmpSalary(2000.0);

            System.out.println("empById = " + employee.getEmpId());
             int empById = mapper.insertEmp(employee);
            System.out.println("empById结束 = " + employee.getEmpId());

//            mapper.insertEmp(new Employee(4, "李四", 5000.0));

            sqlSession.commit();
            sqlSession.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
