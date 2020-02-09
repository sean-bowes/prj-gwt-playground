package com.koisoftware.monet.server.dao;


import com.koisoftware.monet.server.model.User;

import java.util.List;

public interface UserDAO {
    void updateUser(User user);

    void insertUser(User user);

    User getUserById(int userId);

    User getUserByLogin(String login, String password);

    List<User> getUsers();
}
