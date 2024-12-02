import com.linebead.mapper.CustomerMapper;
import com.linebead.mapper.OrderMapper;
import com.linebead.pojo.Order;
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
 * @date 2024年12月02日15:22
 */
public class MyBatisTest {

    private   SqlSession sqlSession;



    /*测试之前*/
    @BeforeEach
    public void before() {
        /*配置文件*/
        String path="mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(path);
            final SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
              sqlSession = build.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Test
    public void test() {
        final OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        final Order order = mapper.queryOrderById(1);
        System.out.println("order = " + order);
    }

    @Test
    public void getList() {
        final CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        final List<CustomerMapper> list = mapper.queryList();
        System.out.println("list = " + list);
    }


    @AfterEach
    public void after() {

        sqlSession.close();

    }

}
