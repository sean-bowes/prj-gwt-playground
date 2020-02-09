package com.koisoftware.monet.server.dao;

import com.koisoftware.monet.server.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(int userId) {
        return (User) sessionFactory.
                getCurrentSession().
                get(User.class, userId);
    }

    @Override
    public User getUserByLogin(String login, String password) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from User where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (User) query.list().get(0);
    }

    @Override
    public List<User> getUsers() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(User.class);
        return criteria.list();
    }
}
