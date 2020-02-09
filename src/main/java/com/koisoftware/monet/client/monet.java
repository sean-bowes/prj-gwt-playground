package com.koisoftware.monet.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.koisoftware.monet.client.app.ui.desktop.MonetDetailView;
import com.koisoftware.monet.client.app.ui.panel.LoginView;
import com.koisoftware.monet.client.record.UserRecord;
import com.koisoftware.monet.client.service.LoginServiceAsync;
import com.koisoftware.monet.client.service.RPCFactory;

import java.util.logging.Logger;

public class monet implements EntryPoint {
    private static final Logger log = Logger.getLogger(monet.class.getName());

    @Override
    public void onModuleLoad() {
        LoginServiceAsync ls = RPCFactory.loginService();
        ls.loginFromSessionServer(new AsyncCallback<UserRecord>() {
            @Override
            public void onFailure(Throwable throwable) {
                Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                    @Override
                    public void execute() {
                        log.severe("ERROR on initial call to server?");
                        log.info("LoginView scheduler is executing");
                        LoginView view = new LoginView();
                        Viewport vp = new Viewport();
                        vp.setWidget(view);
                        RootPanel.get().clear();
                        RootPanel.get().add(vp);
                    }
                });
            }

            @Override
            public void onSuccess(UserRecord userRecord) {
                if (userRecord != null) {
                    //if (userRecord.getUserId() > 0 && userRecord.getLogin().length() > 0) {
                        if (true) {
                        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                            @Override
                            public void execute() {
                                //log.info("MonetDetailView scheduler is executing");
                                //MonetDetailView view = new MonetDetailView();
                                LoginView view = new LoginView();
                                Viewport vp = new Viewport();
                                vp.setWidget(view);
                                RootPanel.get().clear();
                                RootPanel.get().add(vp);
                            }
                        });
                    } else {
                        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                            @Override
                            public void execute() {
                                //log.info("LoginView scheduler is executing");
                                LoginView view = new LoginView();
                                Viewport vp = new Viewport();
                                vp.setWidget(view);
                                RootPanel.get().clear();
                                RootPanel.get().add(vp);
                            }
                        });
                    }
                }
            }
        });
    }
}
