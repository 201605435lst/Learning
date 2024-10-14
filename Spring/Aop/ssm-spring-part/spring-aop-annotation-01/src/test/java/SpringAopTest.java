import com.linebead.config.JavaConfig;
import com.linebead.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


/**
 * @author liushengtao
 * @description 描述
 * @date 2024年10月12日20:16
 */
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int result = calculator.add(1, 2);
        System.out.println(result);
    }


}
