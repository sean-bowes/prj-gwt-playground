package com.koisoftware.monet.client.app.ui.panel;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.*;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.koisoftware.monet.client.record.CustomerRecord;
import com.koisoftware.monet.client.record.UserRecord;

/**
 * Created by sb90320 on 12/14/2014.
 */
public class CustomerEditorView extends SimpleContainer {

    public CustomerEditorView() {
        //#############################
        int fieldWidth = 600;
        VerticalLayoutContainer vLayout = new VerticalLayoutContainer();
        vLayout.setBorders(false);
        //#############################
        TabPanel tabPanelCustomer = new TabPanel();
        tabPanelCustomer.setWidth(700);
        vLayout.add(tabPanelCustomer);
        //#############################
        TabItemConfig tabItemConfigSearch = new TabItemConfig("Search");
        VerticalLayoutContainer vLayoutSearch = new VerticalLayoutContainer();
        //#############################

        //#############################
        tabPanelCustomer.add(vLayoutSearch,tabItemConfigSearch);
        //#############################
        add(vLayout);
        //#############################


//        FieldSet fieldSetSearch = new FieldSet();
//        fieldSetSearch.setHeadingText("Search");
//        fieldSetSearch.setCollapsible(false);
//
//        final TextField loginTextField = new TextField();
//        loginTextField.setWidth(300);
//        FieldLabel loginFieldLabel = new FieldLabel(loginTextField, "Customer Name");
//        fieldSetSearch.add(loginFieldLabel);
//        vTopPanel.add(fieldSetSearch, new VerticalLayoutContainer.VerticalLayoutData(fieldWidth, 100, new Margins(0, 0, 0, 0)));
//
//        FieldSet fieldSetCustomerInformation = new FieldSet();
//        fieldSetCustomerInformation.setHeadingText("Customer Information");
//        fieldSetCustomerInformation.setCollapsible(false);
//        vTopPanel.add(fieldSetCustomerInformation, new VerticalLayoutContainer.VerticalLayoutData(fieldWidth, 300, new Margins(0, 0, 0, 0)));
        //#############################
//        VerticalLayoutContainer vBottomPanel = new VerticalLayoutContainer();
//        vBottomPanel.setBorders(false);
//        FieldSet fieldSetAddressInformation = new FieldSet();
//        fieldSetAddressInformation.setHeadingText("Address Information");
//        fieldSetAddressInformation.setCollapsible(false);
//        vBottomPanel.add(fieldSetAddressInformation, new VerticalLayoutContainer.VerticalLayoutData(fieldWidth, 300, new Margins(0, 0, 0, 0)));
        //vLeftPanel.add(grid, new VerticalLayoutContainer.VerticalLayoutData(-1, 550, new Margins(0, 0, 0, 0)));
        //#############################
//        VBoxLayoutContainer vLayout = new VBoxLayoutContainer();
//        vLayout.setBorders(false);
//        vLayout.add(vTopPanel, new BoxLayoutContainer.BoxLayoutData(new Margins(10, 0, 0, 10)));
//        vLayout.add(vBottomPanel, new BoxLayoutContainer.BoxLayoutData(new Margins(10, 0, 0, 10)));
        //#############################
//        add(vLayout);
        //#############################
    }
    interface CustomerProperties extends PropertyAccess<CustomerRecord> {
        @Editor.Path("userId")
        ModelKeyProvider<CustomerRecord> key();

        @Editor.Path("CustomerId")
        ValueProvider<CustomerRecord, Integer> id();

        @Editor.Path("Company")
        ValueProvider<CustomerRecord, String> company();
    }
}
