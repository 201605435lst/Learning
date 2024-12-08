package com.linebead.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linebead.pojo.Users;

import java.util.List;

public interface UsersService extends IService<Users> {

    List<Users> getPageList(Integer page, Integer pageSize);

    List<Users> queryPage(Integer page, Integer pageSize,Integer age);

}
