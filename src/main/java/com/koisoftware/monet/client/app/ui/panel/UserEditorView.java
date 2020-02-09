package com.koisoftware.monet.client.app.ui.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.loader.ListStoreBinding;
import com.sencha.gxt.data.shared.loader.Loader;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.DefaultInfoConfig;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.info.InfoConfig;
import com.koisoftware.monet.client.record.UserRecord;
import com.koisoftware.monet.client.service.LoginServiceAsync;
import com.koisoftware.monet.client.service.RPCFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserEditorView extends SimpleContainer {
    // private ListView<UserRecord, String> userList;

    public UserEditorView() {
        //#############################
        final DateTimeFormat dtFormatter = DateTimeFormat.getFormat("MM-dd-yyyy hh:mma z");
        //#############################
        final LoginServiceAsync service = RPCFactory.loginService();
        RpcProxy<Object, List<UserRecord>> proxy = new RpcProxy<Object, List<UserRecord>>() {
            @Override
            public void load(Object cfg, AsyncCallback<List<UserRecord>> callback) {
                GWT.log("calling getAllUsers");
                service.getAllUsers(callback);
            }
        };
        final Loader<Object, List<UserRecord>> loader = new Loader<Object, List<UserRecord>>(proxy);
        final ListStore<UserRecord> userRecordStore = new ListStore<UserRecord>(new ModelKeyProvider<UserRecord>() {
            @Override
            public String getKey(UserRecord item) {
                return String.valueOf(item.getUserId());
            }
        });
        loader.addLoadHandler(new ListStoreBinding<Object, UserRecord, List<UserRecord>>(userRecordStore));
        loader.load();
        //#############################
        // example code if you used a list view
//            final UserProperties props = GWT.create(UserProperties.class);
//            userList = new ListView<UserRecord, String>(userRecordStore, props.login());
//            userList.getSelectionModel().setSelectionMode(Style.SelectionMode.SINGLE);
//            userList.setBorders(false);
//
//            VBoxLayoutContainer groupLayout = new VBoxLayoutContainer();
//            groupLayout.add(userList, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 0)));
//            groupLayout.setBorders(true);
//            return groupLayout;

        //#############################
        UserProperties gridProperties = GWT.create(UserProperties.class);
        final ColumnConfig<UserRecord, Integer> idCol = new ColumnConfig<UserRecord, Integer>(gridProperties.id(), 100, "Id");
        idCol.setHidden(true);
        final ColumnConfig<UserRecord, String> nameCol = new ColumnConfig<UserRecord, String>(gridProperties.login(), 200, "Login Name");
        final List<ColumnConfig<UserRecord, ?>> columns = new ArrayList<ColumnConfig<UserRecord, ?>>();
        columns.add(idCol);
        columns.add(nameCol);
        ColumnModel<UserRecord> columnModel = new ColumnModel<UserRecord>(columns);
        //Info.display("getColumnCount=", "'" + columnModel.getColumnCount() + "'");
        //#############################
        Grid<UserRecord> grid = new Grid<UserRecord>(userRecordStore, columnModel);
        grid.getView().setStripeRows(true);
        grid.getView().setColumnLines(false);
        grid.setBorders(false);
        grid.setColumnReordering(true);
        grid.setColumnResize(false);
        //#############################
//        VBoxLayoutContainer groupLayout = new VBoxLayoutContainer();
//        BoxLayoutContainer.BoxLayoutData layoutData = new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 0));
//        layoutData.setMaxSize(150);
//        layoutData.setFlex(0);
//        groupLayout.add(grid, layoutData);
//        return groupLayout;
        //#############################
        final RoleProperties comboProperties = GWT.create(RoleProperties.class);
        final ListStore<RoleRecord> userRoleStore = new ListStore<RoleRecord>(new ModelKeyProvider<RoleRecord>() {
            @Override
            public String getKey(RoleRecord item) {
                return String.valueOf(item.getId());
            }
        });
        List<RoleRecord> userRoleList = new ArrayList<RoleRecord>();
        userRoleList.add(new RoleRecord("0", ""));
        userRoleList.add(new RoleRecord("1", "Administrator"));
        userRoleList.add(new RoleRecord("2", "Manager"));
        userRoleList.add(new RoleRecord("3", "Sales"));
        userRoleStore.addAll((Collection<? extends RoleRecord>) userRoleList);
        //#############################
        VerticalLayoutContainer vLeftPanel = new VerticalLayoutContainer();
        vLeftPanel.setBorders(true);
        vLeftPanel.add(grid, new VerticalLayoutContainer.VerticalLayoutData(-1, 550, new Margins(0, 0, 0, 0)));
        //#############################
        VerticalLayoutContainer vRightPanel = new VerticalLayoutContainer();
        vRightPanel.setBorders(false);
        //#############################
        final TextField userIdTextField = new TextField();
        userIdTextField.setWidth(300);
        //#############################
        final TextField loginTextField = new TextField();
        loginTextField.setAllowBlank(false);
        loginTextField.setWidth(300);
        FieldLabel loginFieldLabel = new FieldLabel(loginTextField, "Login Name");
        vRightPanel.add(loginFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField passwordTextField = new TextField();
        passwordTextField.setAllowBlank(false);
        passwordTextField.setWidth(300);
        FieldLabel passwordFieldLabel = new FieldLabel(passwordTextField, "Password");
        vRightPanel.add(passwordFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField emailTextField = new TextField();
        emailTextField.setAllowBlank(false);
        emailTextField.setWidth(300);
        FieldLabel emailFieldLabel = new FieldLabel(emailTextField, "Email");
        vRightPanel.add(emailFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField displayNameTextField = new TextField();
        displayNameTextField.setAllowBlank(false);
        displayNameTextField.setWidth(300);
        FieldLabel displayNameFieldLabel = new FieldLabel(displayNameTextField, "Display Name");
        vRightPanel.add(displayNameFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final ComboBox<RoleRecord> comboBoxRole = new ComboBox<RoleRecord>(userRoleStore, comboProperties.roleLabel());
        comboBoxRole.setWidth(300);
        comboBoxRole.select(0);
        comboBoxRole.setForceSelection(true);
        comboBoxRole.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
        vRightPanel.add(new FieldLabel(comboBoxRole, "Role"), new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField firstNameTextField = new TextField();
        firstNameTextField.setWidth(300);
        FieldLabel firstNameFieldLabel = new FieldLabel(firstNameTextField, "First Name");
        vRightPanel.add(firstNameFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField lastNameTextField = new TextField();
        lastNameTextField.setWidth(300);
        FieldLabel lastNameFieldLabel = new FieldLabel(lastNameTextField, "Last Name");
        vRightPanel.add(lastNameFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField addressTextField = new TextField();
        addressTextField.setWidth(300);
        FieldLabel addressFieldLabel = new FieldLabel(addressTextField, "Address");
        vRightPanel.add(addressFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField cityTextField = new TextField();
        cityTextField.setWidth(300);
        FieldLabel cityFieldLabel = new FieldLabel(cityTextField, "City");
        vRightPanel.add(cityFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField stateTextField = new TextField();
        stateTextField.setWidth(300);
        FieldLabel stateFieldLabel = new FieldLabel(stateTextField, "State");
        vRightPanel.add(stateFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField postcodeTextField = new TextField();
        postcodeTextField.setWidth(300);
        FieldLabel postcodeFieldLabel = new FieldLabel(postcodeTextField, "Postal Code");
        vRightPanel.add(postcodeFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField loginSidTextField = new TextField();
        loginSidTextField.setWidth(300);
        loginSidTextField.setReadOnly(true);
        FieldLabel loginSidFieldLabel = new FieldLabel(loginSidTextField, "Login SID");
        vRightPanel.add(loginSidFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField loginLastTextField = new TextField();
        loginLastTextField.setWidth(300);
        loginLastTextField.setReadOnly(true);
        FieldLabel loginLastFieldLabel = new FieldLabel(loginLastTextField, "Login Last");
        vRightPanel.add(loginLastFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextField enabledTextField = new TextField();
        enabledTextField.setWidth(300);
        FieldLabel enabledFieldLabel = new FieldLabel(enabledTextField, "Enabled");
        vRightPanel.add(enabledFieldLabel, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        final TextButton saveButton = new TextButton("Save");
        final TextButton resetButton = new TextButton("Reset");
        final TextButton reloadButton = new TextButton("Reload");
        saveButton.setWidth(70);
        saveButton.setHeight(25);
        saveButton.setShadow(true);
        resetButton.setWidth(70);
        resetButton.setHeight(25);
        resetButton.setShadow(true);
        reloadButton.setWidth(70);
        reloadButton.setHeight(25);
        reloadButton.setShadow(true);
        HBoxLayoutContainer btnGroupLayout = new HBoxLayoutContainer();
        btnGroupLayout.add(saveButton, new BoxLayoutContainer.BoxLayoutData(new Margins(20, 0, 0, 0)));
        btnGroupLayout.add(resetButton, new BoxLayoutContainer.BoxLayoutData(new Margins(20, 0, 0, 20)));
        btnGroupLayout.add(reloadButton, new BoxLayoutContainer.BoxLayoutData(new Margins(20, 0, 0, 20)));
        vRightPanel.add(btnGroupLayout, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));

        HBoxLayoutContainer hBoxLayout = new HBoxLayoutContainer();
        //Margins(int top, int right, int bottom, int left)
        hBoxLayout.add(vLeftPanel, new BoxLayoutContainer.BoxLayoutData(new Margins(10, 0, 0, 10)));
        hBoxLayout.add(vRightPanel, new BoxLayoutContainer.BoxLayoutData(new Margins(10, 0, 0, 10)));

        grid.addRowClickHandler(new RowClickEvent.RowClickHandler() {
            @Override
            public void onRowClick(RowClickEvent event) {
                UserRecord ur = userRecordStore.get(event.getRowIndex());
                userIdTextField.setText(String.valueOf(ur.getUserId()));
                loginTextField.setText(ur.getLogin());
                loginTextField.setReadOnly(true);
                passwordTextField.setText(ur.getPassword());
                emailTextField.setText(ur.getEmail());
                displayNameTextField.setText(ur.getDisplayName());
                firstNameTextField.setText(ur.getFirstName());
                lastNameTextField.setText(ur.getLastName());
                addressTextField.setText(ur.getAddress());
                cityTextField.setText(ur.getCity());
                stateTextField.setText(ur.getState());
                postcodeTextField.setText(ur.getPostcode());
                loginSidTextField.setText(ur.getLoginSid());
                loginLastTextField.setText(dtFormatter.format(ur.getLoginLast()));
                enabledTextField.setText(ur.getEnabled());
                if (ur.getRole() == null) {
                    RoleRecord role = userRoleStore.findModelWithKey("3");
                    comboBoxRole.setValue(role);
                } else if (ur.getRole().equals("")) {
                    RoleRecord role = userRoleStore.findModelWithKey("3");
                    comboBoxRole.setValue(role);
                } else {
                    RoleRecord role = userRoleStore.findModelWithKey(ur.getRole());
                    if (role != null) {
                        comboBoxRole.setValue(role);
                    }
                }
            }
        });
        resetButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                userIdTextField.setText(null);
                loginTextField.setText(null);
                loginTextField.setReadOnly(false);
                passwordTextField.setText(null);
                emailTextField.setText(null);
                displayNameTextField.setText(null);
                comboBoxRole.setValue(userRoleStore.findModelWithKey("0"));
                firstNameTextField.setText(null);
                lastNameTextField.setText(null);
                addressTextField.setText(null);
                cityTextField.setText(null);
                stateTextField.setText(null);
                postcodeTextField.setText(null);
                loginSidTextField.setText(null);
                loginLastTextField.setText(null);
                enabledTextField.setText(null);
                saveButton.unmask();
            }
        });
        saveButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                saveButton.mask("Wait");
                LoginServiceAsync ls = RPCFactory.loginService();
                if (userIdTextField.getText() != null && userIdTextField.getText().length() > 0) {
                    UserRecord rc = userRecordStore.findModelWithKey(userIdTextField.getText());
                    //rc.setLogin(loginTextField.getText());
                    rc.setPassword(passwordTextField.getText());
                    rc.setEmail(emailTextField.getText());
                    rc.setDisplayName(displayNameTextField.getText());
                    rc.setRole(comboBoxRole.getValue().getId());
                    rc.setFirstName(firstNameTextField.getText());
                    rc.setLastName(lastNameTextField.getText());
                    rc.setAddress(addressTextField.getText());
                    rc.setCity(cityTextField.getText());
                    rc.setState(stateTextField.getText());
                    rc.setPostcode(postcodeTextField.getText());
                    rc.setEnabled(enabledTextField.getText());
                    ls.update(rc, new VoidAsyncCallback());
                    userRecordStore.update(rc);
                    //DefaultInfoConfig config = new DefaultInfoConfig("Information", "User update successful");
                    DefaultInfoConfig config = new DefaultInfoConfig("Information", comboBoxRole.getValue().getId());
                    config.setPosition(InfoConfig.InfoPosition.BOTTOM_RIGHT);
                    config.setDisplay(2500);
                    Info.display(config);
                } else {
                    UserRecord rc = new UserRecord();
                    rc.setLogin(loginTextField.getText());
                    rc.setPassword(passwordTextField.getText());
                    rc.setEmail(emailTextField.getText());
                    rc.setDisplayName(displayNameTextField.getText());
                    rc.setRole(comboBoxRole.getValue().getId());
                    rc.setFirstName(firstNameTextField.getText());
                    rc.setLastName(lastNameTextField.getText());
                    rc.setAddress(addressTextField.getText());
                    rc.setCity(cityTextField.getText());
                    rc.setState(stateTextField.getText());
                    rc.setPostcode(postcodeTextField.getText());
                    rc.setEnabled(enabledTextField.getText());
                    ls.insert(rc, new VoidAsyncCallback());
                    userRecordStore.add(rc);
                    DefaultInfoConfig config = new DefaultInfoConfig("Information", "User insert successful");
                    config.setPosition(InfoConfig.InfoPosition.BOTTOM_RIGHT);
                    config.setDisplay(2500);
                    Info.display(config);
                }
                loginTextField.setReadOnly(true);
                saveButton.unmask();
            }
        });
        reloadButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                userIdTextField.setText(null);
                loginTextField.setText(null);
                loginTextField.setReadOnly(false);
                passwordTextField.setText(null);
                emailTextField.setText(null);
                displayNameTextField.setText(null);
                comboBoxRole.setValue(userRoleStore.findModelWithKey("0"));
                firstNameTextField.setText(null);
                lastNameTextField.setText(null);
                addressTextField.setText(null);
                cityTextField.setText(null);
                stateTextField.setText(null);
                postcodeTextField.setText(null);
                loginSidTextField.setText(null);
                loginLastTextField.setText(null);
                enabledTextField.setText(null);
                saveButton.unmask();
                loader.load();
            }
        });
        //#############################
        add(hBoxLayout);
        //#############################
    }

    private class VoidAsyncCallback implements AsyncCallback<Void> {
        public void onFailure(Throwable aThrowable) {
        }

        public void onSuccess(Void aResult) {
        }
    }

    interface UserProperties extends PropertyAccess<UserRecord> {
        @Editor.Path("userId")
        ModelKeyProvider<UserRecord> key();

        @Editor.Path("userId")
        ValueProvider<UserRecord, Integer> id();

        @Editor.Path("login")
        ValueProvider<UserRecord, String> login();
    }

    interface RoleProperties extends PropertyAccess<RoleRecord> {
        @Editor.Path("id")
        ModelKeyProvider<RoleRecord> key();

        @Editor.Path("id")
        ValueProvider<RoleRecord, String> id();

        @Editor.Path("type")
        ValueProvider<RoleRecord, String> type();

        @Editor.Path("type")
        LabelProvider<RoleRecord> roleLabel();

    }

    class RoleRecord {
        String id;
        String type;

        public RoleRecord() {

        }

        public RoleRecord(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
