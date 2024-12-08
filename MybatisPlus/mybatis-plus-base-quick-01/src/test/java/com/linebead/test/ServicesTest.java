package com.linebead.test;

import com.linebead.pojo.Users;
import com.linebead.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日21:55
 */
@SpringBootTest
public class ServicesTest {


    /*注入Services*/
    @Autowired
    private UsersService usersService;

    /*批量保存*/
    @Test
    public void test() {
       List<Users> users = new ArrayList<>();

       users.add(Users.builder().name("张三").age(18).email("zhangsan@qq.com").build());
       users.add(Users.builder().name("李四").age(19).email("lisi@qq.com").build());
        final boolean b = usersService.saveBatch(users);

        System.out.println("保存结果：" + b);

    }


}
