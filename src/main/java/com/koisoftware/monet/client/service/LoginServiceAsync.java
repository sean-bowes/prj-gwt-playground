package com.koisoftware.monet.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.koisoftware.monet.client.record.UserRecord;

import java.util.List;

public interface LoginServiceAsync {
    void loginServer(String login, String password, AsyncCallback<UserRecord> anAsyncCallback);

    void loginFromSessionServer(AsyncCallback<UserRecord> anAsyncCallback);

    void changePassword(String login, String newPassword, AsyncCallback<Boolean> anAsyncCallback);

    void logout(AsyncCallback<Void> anAsyncCallback);

    void getAllUsers(AsyncCallback<List<UserRecord>> anAsyncCallback);

    void insert(UserRecord rc, AsyncCallback<Void> anAsyncCallback);

    void update(UserRecord rc, AsyncCallback<Void> anAsyncCallback);
}
