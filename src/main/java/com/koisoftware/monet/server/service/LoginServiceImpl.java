package com.koisoftware.monet.server.service;

import com.koisoftware.monet.client.record.UserRecord;
import com.koisoftware.monet.client.service.LoginService;
import com.koisoftware.monet.server.manager.UserManager;
import com.koisoftware.monet.server.model.User;
import com.koisoftware.monet.server.session.SessionConstant;
import com.koisoftware.monet.server.spring.ApplicationContextHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    private static final Logger log = Logger.getLogger(LoginServiceImpl.class.getName());

    @Override
    public UserRecord loginServer(String login, String password) {
//        log.info("LoginServiceImpl::name=" + login + ",password=" + password);
        UserRecord rc = new UserRecord();
        ApplicationContext ctx = ApplicationContextHolder.getApplicationContext();
        UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");
        User user = null;
        try {
            user = userManager.getUserByLogin(login, password);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString();
            log.severe(sw.toString());
        }
        if (user != null) {
//            log.info("User=" + user.toString());
            user.setLoginLast(new Date());
            user.setLoginSid(java.util.UUID.randomUUID().toString());
            try {
                userManager.updateUser(user);
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                sw.toString();
                log.severe(sw.toString());
            }

            rc.setUserId(user.getUserId());
            rc.setLogin(user.getLogin());
            rc.setPassword(user.getPassword());
            rc.setEmail(user.getEmail());
            rc.setDisplayName(user.getDisplayName());
            rc.setRole(user.getRole() != null ? user.getRole() : "");
            rc.setFirstName(user.getFirstName() != null ? user.getFirstName() : "");
            rc.setLogin(user.getLastName() != null ? user.getLastName() : "");
            rc.setAddress(user.getAddress() != null ? user.getAddress() : "");
            rc.setCity(user.getCity() != null ? user.getCity() : "");
            rc.setState(user.getState() != null ? user.getState() : "");
            rc.setPostcode(user.getPostcode() != null ? user.getPostcode() : "");
            rc.setLoginSid(user.getLoginSid() != null ? user.getLoginSid() : "");
            rc.setLoginLast(user.getLoginLast() != null ? user.getLoginLast() : new Date());
            rc.setEnabled(user.getEnabled() != null ? user.getEnabled() : "");

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            attr.setAttribute(SessionConstant.USER_RECORD, rc, RequestAttributes.SCOPE_SESSION);
            //log.info("User=" + user.toString());
        }
        return rc;
    }

    @Override
    public UserRecord loginFromSessionServer() {
//        log.info("loginFromSessionServer");
        UserRecord rc = new UserRecord();
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if (attr.getAttribute(SessionConstant.USER_RECORD, RequestAttributes.SCOPE_SESSION) != null) {
            rc = (UserRecord) attr.getAttribute(SessionConstant.USER_RECORD, RequestAttributes.SCOPE_SESSION);
//            log.info("loginFromSessionServer session user found!");
        }
        return rc;
    }

    @Override
    public boolean changePassword(String name, String newPassword) {
        return true;
    }

    @Override
    public void logout() {
//        log.info("loginFromSessionServer session removed");
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.removeAttribute(SessionConstant.USER_RECORD, RequestAttributes.SCOPE_SESSION);
    }

    @Override
    public List<UserRecord> getAllUsers() {
        ApplicationContext ctx = ApplicationContextHolder.getApplicationContext();
        UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");
        List<User> users = null;
        try {
            users = userManager.getUsers();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString();
            log.severe(sw.toString());
        }
        ArrayList<UserRecord> outUsers = new ArrayList<UserRecord>();
        UserRecord rc = null;
        if (users != null) {
            for (User user : users) {
                rc = new UserRecord();

                rc.setUserId(user.getUserId());
                rc.setLogin(user.getLogin());
                rc.setPassword(user.getPassword());
                rc.setEmail(user.getEmail());
                rc.setDisplayName(user.getDisplayName());
                rc.setRole(user.getRole() != null ? user.getRole() : "");
                rc.setFirstName(user.getFirstName() != null ? user.getFirstName() : "");
                rc.setLastName(user.getLastName() != null ? user.getLastName() : "");
                rc.setAddress(user.getAddress() != null ? user.getAddress() : "");
                rc.setCity(user.getCity() != null ? user.getCity() : "");
                rc.setState(user.getState() != null ? user.getState() : "");
                rc.setPostcode(user.getPostcode() != null ? user.getPostcode() : "");
                rc.setLoginSid(user.getLoginSid() != null ? user.getLoginSid() : "");
                rc.setLoginLast(user.getLoginLast() != null ? user.getLoginLast() : new Date());
                rc.setEnabled(user.getEnabled() != null ? user.getEnabled() : "");

                //log.info("#################");
                //log.info("user=" + user.toString());
                //log.info("rc=" + rc.toString());
                //log.info("user getLogin=" + user.getLogin());
                //log.info("rc getLogin=" + rc.getLogin());
                //log.info("#################");

                outUsers.add(rc);
            }
        }
        return outUsers;
    }

    @Override
    public void insert(UserRecord rc) {
        ApplicationContext ctx = ApplicationContextHolder.getApplicationContext();
        UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");
        User user = new User();
        user.setLogin(rc.getLogin());
        user.setPassword(rc.getPassword());
        user.setEmail(rc.getEmail());
        user.setDisplayName(rc.getDisplayName());
        user.setRole(rc.getRole());
        user.setFirstName(rc.getFirstName());
        user.setLastName(rc.getLastName());
        user.setAddress(rc.getAddress());
        user.setCity(rc.getCity());
        user.setState(rc.getState());
        user.setPostcode(rc.getPostcode());
        user.setEnabled(rc.getEnabled());
        userManager.insertUser(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(UserRecord rc) {
        ApplicationContext ctx = ApplicationContextHolder.getApplicationContext();
        UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");
        User user = userManager.getUserById(rc.getUserId());
        user.setLogin(rc.getLogin());
        user.setPassword(rc.getPassword());
        user.setEmail(rc.getEmail());
        user.setDisplayName(rc.getDisplayName());
        user.setRole(rc.getRole());
        user.setFirstName(rc.getFirstName());
        user.setLastName(rc.getLastName());
        user.setAddress(rc.getAddress());
        user.setCity(rc.getCity());
        user.setState(rc.getState());
        user.setPostcode(rc.getPostcode());
        user.setEnabled(rc.getEnabled());
        userManager.updateUser(user);

        log.info("#################");
        log.info("user=" + user.toString());
        log.info("rc=" + rc.toString());
        log.info("user getLogin=" + user.getLogin());
        log.info("rc getLogin=" + rc.getLogin());
        log.info("#################");
    }

}
