package com.linebead.service;

import com.linebead.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    int delete(int id);
}
