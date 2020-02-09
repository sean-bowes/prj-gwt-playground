package com.koisoftware.monet.client.app.ui.panel;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import com.sencha.gxt.widget.core.client.menu.SeparatorMenuItem;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.koisoftware.monet.client.app.ui.images.ResourceImages;

public class HomeView extends SimpleContainer {
    //private SimpleContainer root;
    private SimpleContainer workspace;
    private UserEditorView userEditorView;
    private CustomerEditorView customerEditorView;

    public SimpleContainer getWorkspace() {
        return workspace;
    }

    public HomeView() {
        // ##############################
        workspace = new SimpleContainer();
        workspace.setStyleName("gwt-Container-Workspace");
        // ##############################
        ToolBar toolBar = new ToolBar();
        // ##############################
        TextButton itemConfiguration = new TextButton("Configuration");
        itemConfiguration.setIcon(ResourceImages.INSTANCE.menu_show());
        toolBar.add(itemConfiguration);

        Menu menuConfiguration = new Menu();
        itemConfiguration.setMenu(menuConfiguration);
        menuConfiguration.addSelectionHandler(handler);

        MenuItem itemConfigurationUser = new MenuItem("User Configuration");
        menuConfiguration.add(itemConfigurationUser);
        // ##############################
        TextButton itemCustomerManager = new TextButton("Customer Manager");
        toolBar.add(new SeparatorToolItem());
        toolBar.add(itemCustomerManager);

        Menu menuCustomerManager = new Menu();
        itemCustomerManager.setMenu(menuCustomerManager);
        menuCustomerManager.addSelectionHandler(handler);

        MenuItem itemCustomerEditor = new MenuItem("Customer Editor");
        menuCustomerManager.add(itemCustomerEditor);

        MenuItem itemCustomerAssociations = new MenuItem("Customer Associations");
        menuCustomerManager.add(new SeparatorMenuItem());
        menuCustomerManager.add(itemCustomerAssociations);
        // ##############################
        VerticalLayoutContainer rootLayout = new VerticalLayoutContainer();
        rootLayout.setBorders(false);
        rootLayout.add(toolBar, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));
        rootLayout.add(workspace, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0, 0, 0, 0)));
        // ##############################
        add(rootLayout);
    }

    private SelectionHandler<Item> handler = new SelectionHandler<Item>() {
        @Override
        public void onSelection(SelectionEvent<Item> event) {
            MenuItem item = (MenuItem) event.getSelectedItem();
            if (item.getText().equals("User Configuration")) {
                Info.display("Menu=", "'User Configuration'");
                if (userEditorView == null) {
                    userEditorView = new UserEditorView();
                }
                workspace.clear();
                workspace.add(userEditorView);
            } else if (item.getText().equals("Customer Editor")) {
                if (customerEditorView ==null) {
                    customerEditorView = new CustomerEditorView();
                }
                workspace.clear();
                workspace.add(customerEditorView);
            } else if (item.getText().equals("Customer Associations")) {
            } else if (item.getText().equals("")) {
            } else {
            }
        }
    };
}
