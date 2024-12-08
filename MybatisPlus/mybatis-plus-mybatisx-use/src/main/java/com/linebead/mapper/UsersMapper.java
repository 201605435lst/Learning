package com.linebead.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.linebead.pojo.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author liushengtao
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-12-08 10:55:17
* @Entity com.linebead.pojo.Users
*/
public interface UsersMapper extends BaseMapper<Users> {

    List<Users> findByNameAndAge(@Param("name") String name, @Param("age") Integer age);

}




