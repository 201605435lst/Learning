package com.linebead.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linebead.mapper.UsersMapper;
import com.linebead.pojo.Users;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月08日0:11
 */
@SpringBootTest
public class QueryWarperTest {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
    public void testQueryWarperList(){
        QueryWrapper<Users> usersQueryWrapper=new QueryWrapper<>();

        /*用户名包含a*/
        usersQueryWrapper.like("name","a");
//        年龄在20到30之间

        usersQueryWrapper.between("age",20,30);
//        并且邮箱不为null的用户信息
        usersQueryWrapper.isNotNull("email");

        /*上面等价于*/
//        usersQueryWrapper.like("name","a").between("age",20,30).isNotNull("email");


        final List<Users> users = usersMapper.selectList(usersQueryWrapper);

        System.out.println("users = " + users);

    }

    //按年龄降序查询用户，如果年龄相同则按id升序排列
    @Test
    public void test2(){
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
//        按年龄降序查询用户

        queryWrapper.orderByDesc("age");

//        按id升序

        queryWrapper.orderByAsc("id");
        final List<Users> users = usersMapper.selectList(queryWrapper);
        System.out.println("users = " + users);

    }

    //删除email为空的用户
    @Test
    public void deleteTest(){

        QueryWrapper<Users> queryWrapper =new QueryWrapper<>();
        queryWrapper.isNull("email");
        usersMapper.delete(queryWrapper);

    }

    //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改

    @Test
    public void test3(){
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
//        年龄大于20
        queryWrapper.gt("age",20);
        /*用户名中包含有a*/
        queryWrapper.like("name","a");

        /*或*/
        queryWrapper.or();

        /*邮箱为null*/
        queryWrapper.isNotNull("email");
//        SELECT id,name,age,email FROM users WHERE (age > ? AND name LIKE ? OR email IS NOT NULL)
        final List<Users> users = usersMapper.selectList(queryWrapper);
        System.out.println("users = " + users);


    }

    //查询用户信息的username和age字段
    @Test
    public void test5(){
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("id",1L);
        queryWrapper.select("name","age");

        usersMapper.selectMaps(queryWrapper);

    }
    //查询用户信息的username和age字段
    @Test
    public void test6(){
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        //selectMaps()返回Map集合列表，通常配合select()使用，避免User对象中没有被查询到的列值为null
        usersMapper.selectList(queryWrapper);

    }

    //判断条件拼接
    //当name不为null拼接等于, age > 1 拼接等于判断
    @Test
    public void  test7(){
        String nameValue="a";
        int age=10;

        QueryWrapper<Users> queryWrapper =new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(nameValue),"name",nameValue);

        queryWrapper.gt(true,"age",age);

        usersMapper.selectList(queryWrapper);


    }


}
