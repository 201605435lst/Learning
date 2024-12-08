package com.linebead.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linebead.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    /*自定义的mapper方法使用分页*/
    IPage<Users> queryByPage(IPage<Users> page,@Param("age") Integer age);

}
