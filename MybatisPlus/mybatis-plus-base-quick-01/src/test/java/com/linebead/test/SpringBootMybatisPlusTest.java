package com.linebead.test;

import com.linebead.mapper.UsersMapper;
import com.linebead.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日20:40
 */
@SpringBootTest
public class SpringBootMybatisPlusTest {
    /*引入mapper*/
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void test() {
        List<Users> user = usersMapper.selectList(null);
        System.out.println(user);
    }


    @Test
    public void selectById() {
        Users user = usersMapper.selectById(1);
        System.out.println(user);
    }




}
