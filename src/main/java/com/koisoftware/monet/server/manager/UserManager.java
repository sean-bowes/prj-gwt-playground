package com.koisoftware.monet.server.manager;

import com.koisoftware.monet.server.model.User;

import java.util.List;

/**
 * Created by sb90320 on 11/27/2014.
 */
public interface UserManager {
    void updateUser(User user);

    void insertUser(User user);

    User getUserById(int userId);

    User getUserByLogin(String login, String password);

    List<User> getUsers();
}
