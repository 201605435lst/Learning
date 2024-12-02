import com.linebead.config.JavaConfig;
import com.linebead.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年10月15日15:55
 */
/*引入配置类*/
@SpringJUnitConfig(value = JavaConfig.class)
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testStudent() {
        studentService.changeInfo();
    }

}
