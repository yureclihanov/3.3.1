package com.springboot.servise;


import com.springboot.model.User;

import java.util.List;

public interface Servise {

    List<User> allUsers();
    User findUserById(int id);
    void add(User user);
    User update(User user);
    void deleteById(int id);
}
