package Test01;

import com.study.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void Test01(){

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);

        System.out.println("JavaBean="+javaBean);
    }
}
