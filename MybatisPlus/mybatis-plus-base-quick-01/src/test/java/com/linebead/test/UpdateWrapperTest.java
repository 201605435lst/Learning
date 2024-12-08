package com.linebead.test;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.linebead.mapper.UsersMapper;
import com.linebead.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月08日1:12
 */
@SpringBootTest
public class UpdateWrapperTest {

    @Autowired
    private UsersMapper usersMapper;

    //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
    @Test
    public void test(){
        UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
        updateWrapper.gt("age",10);
        updateWrapper.like("name","a");
        updateWrapper.isNull("email");
        updateWrapper.set("email","@1316192871");

        usersMapper.update(null,updateWrapper);


    }


}
