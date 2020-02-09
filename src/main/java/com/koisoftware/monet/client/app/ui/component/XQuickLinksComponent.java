package com.koisoftware.monet.client.app.ui.component;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.*;
import com.koisoftware.monet.client.app.ui.desktop.MonetDetailView;
import com.koisoftware.monet.client.app.ui.panel.LoginView;
import com.koisoftware.monet.client.service.LoginServiceAsync;
import com.koisoftware.monet.client.service.RPCFactory;

import java.util.logging.Logger;


public class XQuickLinksComponent extends SimpleContainer {
    private static final Logger log = Logger.getLogger(XQuickLinksComponent.class.getName());

    public MonetDetailView getMainView() {
        return mainView;
    }

    public void setMainView(MonetDetailView mainView) {
        this.mainView = mainView;
    }

    private Label instanceEnvLabel = new Label();
    private Label unreadAlertsLabel = new Label();
    private Label homeLabel = new Label();
    private Label viewAlertsLabel = new Label();
    private Label logoutLabel = new Label();
    private Label pipeLabel1 = new Label();
    private Label pipeLabel2 = new Label();
    private MonetDetailView mainView;

    public XQuickLinksComponent() {
        //#############################
        VBoxLayoutContainer layout = new VBoxLayoutContainer();
        //#############################
        instanceEnvLabel.setText("Instance GWD054");
        unreadAlertsLabel.setText("52 unread alert");
        homeLabel.setText("Home");
        viewAlertsLabel.setText("View alerts");
        logoutLabel.setText("Logout");
        pipeLabel1.setText("|");
        pipeLabel2.setText("|");
        //#############################
        instanceEnvLabel.setWordWrap(false);
        unreadAlertsLabel.setWordWrap(false);
        homeLabel.setWordWrap(false);
        viewAlertsLabel.setWordWrap(false);
        logoutLabel.setWordWrap(false);
        //#############################
        instanceEnvLabel.setStyleName("gwt-Instance-Label");
        unreadAlertsLabel.setStyleName("gwt-Alerts-Label");
        homeLabel.setStyleName("gwt-ViewHome-Label");
        viewAlertsLabel.setStyleName("gwt-ViewAlerts-Label");
        logoutLabel.setStyleName("gwt-Logout-Label");
        pipeLabel1.setStyleName("gwt-Pipe-Label");
        pipeLabel2.setStyleName("gwt-Pipe-Label");
        //#############################
        //Margins(int top, int right, int bottom, int left)
        layout.add(instanceEnvLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(15, 0, 0, 0)));
        layout.add(unreadAlertsLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(5, 0, 0, 0)));
        //#############################
        HBoxLayoutContainer hAlertsGroupLayout = new HBoxLayoutContainer();
        hAlertsGroupLayout.add(homeLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 0)));
        hAlertsGroupLayout.add(pipeLabel1, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 5)));
        hAlertsGroupLayout.add(viewAlertsLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 5)));
        hAlertsGroupLayout.add(pipeLabel2, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 5)));
        hAlertsGroupLayout.add(logoutLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 5)));
        //#############################
        layout.add(hAlertsGroupLayout, new BoxLayoutContainer.BoxLayoutData(new Margins(5, 0, 0, 0)));
        //#############################
        homeLabel.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                homeLabel.addStyleName("gwt-ViewHome-Label-Hover");
                homeLabel.getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        });
        homeLabel.addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                homeLabel.removeStyleName("gwt-ViewHome-Label-Hover");
            }
        });
        homeLabel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //log.info("adding home to center");
                //log.info("widget before cnt=" + mainView.getCenter().getWidgetCount());
                mainView.getCenter().clear();
                //log.info("widget after cnt=" + mainView.getCenter().getWidgetCount());
                mainView.getHomeView().getWorkspace().clear();
                mainView.getCenter().add(mainView.getHomeView());
            }
        });
        viewAlertsLabel.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                viewAlertsLabel.addStyleName("gwt-ViewAlerts-Label-Hover");
                viewAlertsLabel.getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        });
        viewAlertsLabel.addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                viewAlertsLabel.removeStyleName("gwt-ViewAlerts-Label-Hover");
            }
        });
        viewAlertsLabel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                mainView.getCenter().remove(0);
                mainView.getCenter().add(mainView.getAlertsView());
            }
        });
        logoutLabel.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                logoutLabel.addStyleName("gwt-Logout-Label-Hover");
                logoutLabel.getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        });
        logoutLabel.addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                logoutLabel.removeStyleName("gwt-Logout-Label-Hover");
            }
        });
        logoutLabel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                LoginServiceAsync ls = RPCFactory.loginService();
                ls.logout(new VoidAsyncCallback());
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        //log.info("LoginView scheduler is executing via quicklinks");
                        LoginView view = new LoginView();
                        Viewport vp = new Viewport();
                        vp.setWidget(view);
                        RootPanel.get().clear();
                        RootPanel.get().add(vp);
                    }
                });
            }
        });
        //#############################
        add(layout);
        //#############################
    }

    private class VoidAsyncCallback implements AsyncCallback<Void> {
        public void onFailure(Throwable aThrowable) {
        }

        public void onSuccess(Void aResult) {
        }
    }
}
