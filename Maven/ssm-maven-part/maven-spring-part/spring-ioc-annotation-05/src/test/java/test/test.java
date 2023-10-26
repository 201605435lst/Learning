package test;

import com.cn.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testDemo(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("student.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        System.out.println(studentController.findAll());

    }
}
