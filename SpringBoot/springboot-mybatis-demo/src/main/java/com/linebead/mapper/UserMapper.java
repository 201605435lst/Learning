package com.linebead.mapper;

import com.linebead.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    int delete(int id);
}
