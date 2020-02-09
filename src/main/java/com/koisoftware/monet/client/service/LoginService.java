package com.koisoftware.monet.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.koisoftware.monet.client.record.UserRecord;

import java.util.List;

@RemoteServiceRelativePath("springGwtServices/LoginService")
public interface LoginService extends RemoteService {

    UserRecord loginServer(String login, String password);

    UserRecord loginFromSessionServer();

    boolean changePassword(String login, String newPassword);

    void logout();

    List<UserRecord> getAllUsers();

    void insert(UserRecord rc);

    void update(UserRecord rc);

}
