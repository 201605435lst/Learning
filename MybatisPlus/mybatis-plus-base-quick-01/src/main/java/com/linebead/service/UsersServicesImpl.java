package com.linebead.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linebead.mapper.UsersMapper;
import com.linebead.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日21:46
 */
@Service
public class UsersServicesImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public List<Users> getPageList(Integer pageNum, Integer pageSize) {

        Page<Users> page = new Page<>(pageNum, pageSize);
        /*分页*/
        usersMapper.selectPage(page, null);

        //获取分页数据
        List<Users> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
        return list;
    }


    /*自定义方法*/
    @Override
    public List<Users> queryPage(Integer page, Integer pageSize,Integer age) {
        Page<Users> pg=new Page<>(page,pageSize);

         usersMapper.queryByPage(pg,age);

        //获取分页数据
        List<Users> list = pg.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+pg.getCurrent());
        System.out.println("每页显示的条数："+pg.getSize());
        System.out.println("总记录数："+pg.getTotal());
        System.out.println("总页数："+pg.getPages());
        System.out.println("是否有上一页："+pg.hasPrevious());
        System.out.println("是否有下一页："+pg.hasNext());
        return list;
    }
}
