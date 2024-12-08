package com.linebead.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linebead.pojo.Users;
import com.linebead.service.UsersService;
import com.linebead.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author liushengtao
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-12-08 10:55:17
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




