package com.koisoftware.monet.server.manager;

import com.koisoftware.monet.server.dao.UserDAO;
import com.koisoftware.monet.server.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManagerImpl implements UserManager {
    protected static final Logger LOG = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByLogin(String login, String password) {
        return userDAO.getUserByLogin(login, password);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
