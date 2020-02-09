package com.koisoftware.monet.client.app.ui.desktop;

import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.koisoftware.monet.client.app.ui.component.XClockComponent;
import com.koisoftware.monet.client.app.ui.component.XQuickLinksComponent;
import com.koisoftware.monet.client.app.ui.panel.AlertsView;
import com.koisoftware.monet.client.app.ui.panel.HomeView;

import java.util.logging.Logger;

public class MonetDetailView extends SimpleContainer {

    private static final Logger log = Logger.getLogger(MonetDetailView.class.getName());
    private XQuickLinksComponent alertComponent;
    private XClockComponent clockComponent1;
    private XClockComponent clockComponent2;
    private XClockComponent clockComponent3;
    private AlertsView alertsView;
    private HomeView homeView;
    private ContentPanel north;
    private ContentPanel west;
    private ContentPanel center;

    public MonetDetailView() {
        //#############################
        BorderLayoutContainer layout = new BorderLayoutContainer();
        //#############################
        north = new ContentPanel();
        west = new ContentPanel();
        center = new ContentPanel();
        north.setHeadingText("Gateway Solutions");
        west.setHeadingText("Search");
        north.setBodyStyle("background:white url('images/header-banner.jpg') no-repeat top left");
        center.setBodyStyle("background:white url('images/background-panel.jpg') no-repeat top left");
        west.setBodyStyle("background:white url('images/background-panel.jpg') no-repeat top left");
        //#############################
        //<editor-fold desc="northData">
        BorderLayoutContainer.BorderLayoutData northData = new BorderLayoutContainer.BorderLayoutData(100);
        northData.setMargins(new Margins(2));
        northData.setSplit(true);
        northData.setCollapsible(true);
        northData.setCollapseMini(true);
        northData.setSplit(true);
        northData.setMaxSize(100);
        layout.setNorthWidget(north, northData);
        //</editor-fold>
        //#############################
        //<editor-fold desc="headerComponents">
        HBoxLayoutContainer northLayout = new HBoxLayoutContainer();
        alertComponent = new XQuickLinksComponent();
        clockComponent1 = new XClockComponent();
        clockComponent2 = new XClockComponent();
        clockComponent3 = new XClockComponent();
        clockComponent1.createMessageGeneratorService("America/New_York");
        clockComponent2.createMessageGeneratorService("America/Chicago");
        clockComponent3.createMessageGeneratorService("America/Los_Angeles");
        alertComponent.setMainView(this);
        northLayout.add(clockComponent1, new BoxLayoutData(new Margins(0, 0, 0, 400)));
        northLayout.add(clockComponent2, new BoxLayoutData(new Margins(0, 0, 0, 20)));
        northLayout.add(clockComponent3, new BoxLayoutData(new Margins(0, 0, 0, 20)));
        northLayout.add(alertComponent, new BoxLayoutData(new Margins(0, 0, 0, 100)));
        north.add(northLayout);
        //</editor-fold>
        //#############################
        //<editor-fold desc="westData">
        BorderLayoutContainer.BorderLayoutData westData = new BorderLayoutContainer.BorderLayoutData(200);
        westData.setMargins(new Margins(0, 2, 2, 2));
        westData.setSplit(true);
        westData.setCollapsed(true);
        westData.setCollapsible(true);
        westData.setCollapseMini(true);
        westData.setSplit(true);
        westData.setMaxSize(200);
        layout.setWestWidget(west, westData);
        //</editor-fold>
        //#############################
        //TODO: Need to add code for the search screen.
        VerticalLayoutContainer westLayout = new VerticalLayoutContainer();
        west.add(westLayout);
        //#############################
        //<editor-fold desc="centerData">
        BorderLayoutContainer.BorderLayoutData centerData = new BorderLayoutContainer.BorderLayoutData();
        centerData.setMargins(new Margins(0, 2, 2, 2));
        centerData.setCollapsible(true);
        centerData.setSplit(true);
        layout.setCenterWidget(center, centerData);
        //</editor-fold>
        //#############################
        //TODO: Need to add code for center screen
        VerticalLayoutContainer centerLayout = new VerticalLayoutContainer();
        center.add(centerLayout);
        //#############################
        layout.hide(Style.LayoutRegion.SOUTH);
        layout.hide(Style.LayoutRegion.EAST);
        //#############################
        add(layout);
        //#############################
    }

    public ContentPanel getNorth() {
        return north;
    }

    public void setNorth(ContentPanel north) {
        this.north = north;
    }

    public ContentPanel getWest() {
        return west;
    }

    public void setWest(ContentPanel west) {
        this.west = west;
    }

    public ContentPanel getCenter() {
        return center;
    }

    public void setCenter(ContentPanel center) {
        this.center = center;
    }

    public XQuickLinksComponent getalertComponent() {
        return alertComponent;
    }

    public void setalertComponent(XQuickLinksComponent alertComponent) {
        this.alertComponent = alertComponent;
    }

    public XClockComponent getclockComponent1() {
        return clockComponent1;
    }

    public void setclockComponent1(XClockComponent clockComponent1) {
        this.clockComponent1 = clockComponent1;
    }

    public XClockComponent getclockComponent2() {
        return clockComponent2;
    }

    public void setclockComponent2(XClockComponent clockComponent2) {
        this.clockComponent2 = clockComponent2;
    }

    public XClockComponent getclockComponent3() {
        return clockComponent3;
    }

    public void setclockComponent3(XClockComponent clockComponent3) {
        this.clockComponent3 = clockComponent3;
    }

    public AlertsView getAlertsView() {
        if (alertsView == null) {
            alertsView = new AlertsView();
        }
        return alertsView;
    }

    public void setAlertsView(AlertsView alertsView) {
        this.alertsView = alertsView;
    }

    public HomeView getHomeView() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;
    }

    public void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }
}
