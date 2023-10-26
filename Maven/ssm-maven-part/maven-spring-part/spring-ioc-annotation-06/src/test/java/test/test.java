package test;

import com.cn.config.StudentConfig;
import com.cn.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {

    @Test
    public void testDemo(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentController controller = applicationContext.getBean(StudentController.class);
        System.out.println(controller.getAll());
    }
}
