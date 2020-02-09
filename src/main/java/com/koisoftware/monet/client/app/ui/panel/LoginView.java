package com.koisoftware.monet.client.app.ui.panel;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.*;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.DefaultInfoConfig;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.info.InfoConfig;
import com.koisoftware.monet.client.app.ui.desktop.MonetDetailView;
import com.koisoftware.monet.client.record.UserRecord;
import com.koisoftware.monet.client.service.LoginServiceAsync;
import com.koisoftware.monet.client.service.RPCFactory;

import java.util.logging.Logger;

public class LoginView extends SimpleContainer {
    private static final Logger log = Logger.getLogger(LoginView.class.getName());
    // private SimpleContainer root;
    private final TextField loginField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final TextButton loginButton = new TextButton("Login");
    private final TextButton resetButton = new TextButton("Reset");

    public LoginView() {
        //#############################
        VBoxLayoutContainer vLayout = new VBoxLayoutContainer();
        //#############################
        vLayout.setStyleName("loginView");
        //#############################
        Label headerLabel = new Label("Gateway Solutions Login - admin");
        //Margins(int top, int right, int bottom, int left)
        vLayout.add(headerLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(200, 0, 0, 200)));
        //#############################
//        RequiredTextFieldStyle requiredTextFieldStyle = GWT.create(RequiredTextFieldStyle.class);
//        final TextInputCell loginInputCell = new TextInputCell(new TextFieldDefaultAppearance(requiredTextFieldStyle));
//        final TextField loginField = new TextField(loginInputCell);
//        EmptyValidator<String> myValidator = new EmptyValidator<String>();
//        myValidator.setMessages(new EmptyValidator.EmptyMessages() {
//            @Override
//            public String blankText() {
//                return "your text";
//            }
//        });
//        loginField.addValidator(myValidator);
        loginField.setAllowBlank(false);
        loginField.setEmptyText("Enter your login id ...");
        vLayout.add(new FieldLabel(loginField, "Login Id"), new BoxLayoutContainer.BoxLayoutData(new Margins(20, 0, 0, 200)));
        //#############################
        passwordField.setAllowBlank(false);
        passwordField.setEmptyText("Enter your password ...");
        vLayout.add(new FieldLabel(passwordField, "Password"), new BoxLayoutContainer.BoxLayoutData(new Margins(5, 0, 0, 200)));
        //#############################
        loginButton.setWidth(70);
        loginButton.setHeight(25);
        loginButton.setShadow(true);
        resetButton.setWidth(70);
        resetButton.setHeight(25);
        resetButton.setShadow(true);
        HBoxLayoutContainer btnGroupLayout = new HBoxLayoutContainer();
        btnGroupLayout.add(loginButton, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 0)));
        btnGroupLayout.add(resetButton, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 20)));
        vLayout.add(btnGroupLayout, new BoxLayoutContainer.BoxLayoutData(new Margins(5, 0, 0, 200)));
        //#############################
        final Label disclaimerLabel = new Label("Disclaimer");
        disclaimerLabel.setStyleName("gwt-loginView-Disclaimer");
        vLayout.add(disclaimerLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(15, 0, 0, 200)));
        //#############################
        disclaimerLabel.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                disclaimerLabel.addStyleName("gwt-loginView-Disclaimer-Hover");
                disclaimerLabel.getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        });
        disclaimerLabel.addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                disclaimerLabel.removeStyleName("gwt-loginView-Disclaimer-Hover");
            }
        });
        disclaimerLabel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                DefaultInfoConfig config = new DefaultInfoConfig("Information", "Disclaimer ...");
                config.setPosition(InfoConfig.InfoPosition.BOTTOM_RIGHT);
                config.setDisplay(2500);
                Info.display(config);
            }
        });
        resetButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                loginField.setText(null);
                passwordField.setText(null);
                loginButton.unmask();
            }
        });
        passwordField.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
                    //fireEvent();
                }
            }
        });
        loginButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                fireEvent();
            }
        });
        sinkEvents(Event.ONKEYDOWN | Event.ONKEYPRESS);
        add(vLayout);
    }

    @Override
    public void onBrowserEvent(Event event) {
        int eventType = DOM.eventGetType(event);
        int eventCode = event.getKeyCode();
        if (eventType == Event.ONKEYDOWN && eventCode == KeyCodes.KEY_ENTER) {
            fireEvent();
        }
        super.onBrowserEvent(event);
    }

    private void fireEvent() {
        loginButton.mask("Wait");
        final String login = loginField.getText();
        final String password = passwordField.getText();

        LoginServiceAsync ls = RPCFactory.loginService();
        ls.loginServer(login, password, new AsyncCallback<UserRecord>() {
            @Override
            public void onFailure(Throwable throwable) {
                DefaultInfoConfig config = new DefaultInfoConfig("Exception", "Check logs");
                config.setPosition(InfoConfig.InfoPosition.BOTTOM_RIGHT);
                config.setDisplay(2500);
                Info.display(config);
                loginButton.unmask();
            }

            @Override
            public void onSuccess(UserRecord userRecord) {
                if (userRecord != null) {
                    if (userRecord.getLogin() == null) {
                        DefaultInfoConfig config = new DefaultInfoConfig("Information", "Invalid login");
                        config.setPosition(InfoConfig.InfoPosition.BOTTOM_RIGHT);
                        config.setDisplay(2500);
                        Info.display(config);
                        loginButton.unmask();
                    } else if (!userRecord.getEnabled().equals("Y")) {
                        DefaultInfoConfig config = new DefaultInfoConfig("Information", "Login not enabled");
                        config.setPosition(InfoConfig.InfoPosition.BOTTOM_RIGHT);
                        config.setDisplay(2500);
                        Info.display(config);
                        loginButton.unmask();
                    } else {
                        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                            @Override
                            public void execute() {
                                MonetDetailView view = new MonetDetailView();
                                Viewport vp = new Viewport();
                                vp.setWidget(view);
                                RootPanel.get().clear();
                                RootPanel.get().add(vp);
                            }
                        });
                    }
                } else {
                    log.info("userRecord is null");
                    DefaultInfoConfig config = new DefaultInfoConfig("Exception", "Null value?");
                    config.setPosition(InfoConfig.InfoPosition.BOTTOM_RIGHT);
                    config.setDisplay(2500);
                    Info.display(config);
                    loginButton.unmask();
                }
            }
        });
    }
}
