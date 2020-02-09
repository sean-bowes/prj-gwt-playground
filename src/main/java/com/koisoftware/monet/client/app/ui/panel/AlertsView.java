package com.koisoftware.monet.client.app.ui.panel;

import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;

public class AlertsView extends SimpleContainer {
    private final Label alertsHeaderLabel = new Label();
    //private SimpleContainer root;

    public AlertsView() {
        VBoxLayoutContainer vLayout = new VBoxLayoutContainer();
        alertsHeaderLabel.setText("View Alerts");
        alertsHeaderLabel.setWordWrap(false);
        alertsHeaderLabel.setStyleName("gwt-ViewAlerts-Label-Header");
        //Margins(int top, int right, int bottom, int left)
        vLayout.add(alertsHeaderLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(5, 0, 0, 5)));
        add(vLayout);
    }
}
