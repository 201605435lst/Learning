package com.linebead.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.linebead.mapper.UsersMapper;
import com.linebead.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月08日1:31
 */
@SpringBootTest
public class LamdaQueryWrapperTest {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void test(){
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息

        LambdaQueryWrapper<Users> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Users::getName,"a");
        lambdaQueryWrapper.between(Users::getAge,20,30);
        lambdaQueryWrapper.isNotNull(Users::getEmail);

        usersMapper.selectList(lambdaQueryWrapper);

    }

}
