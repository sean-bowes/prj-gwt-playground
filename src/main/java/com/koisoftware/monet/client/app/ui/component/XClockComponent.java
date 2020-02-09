package com.koisoftware.monet.client.app.ui.component;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.koisoftware.monet.client.service.RPCFactory;
import com.koisoftware.monet.client.service.ServerGeneratedMessageDateTimeServiceAsync;
import com.koisoftware.monet.client.service.event.ServerGeneratedMessageDateTimeEvent;
import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.listener.RemoteEventListener;

import java.util.logging.Logger;

/**
 * Created by sb90320 on 11/18/2014.
 */
public class XClockComponent extends SimpleContainer {
    private static final Logger log = Logger.getLogger(XClockComponent.class.getName());

    public Label getCityLabel() {
        return cityLabel;
    }

    public void setCityLabel(Label cityLabel) {
        this.cityLabel = cityLabel;
    }

    public Label getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(Label dateLabel) {
        this.dateLabel = dateLabel;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    private Label cityLabel = new Label();
    private Label dateLabel = new Label();
    private Label timeLabel = new Label();
    private String timeZone = "";

    public void createMessageGeneratorService(String msg) {
        //log.info("######################");
        //log.info("### createMessageGeneratorService timeZone=" + msg);
        timeZone = msg;
        if (timeZone.equals("America/New_York")) {
            cityLabel.setText("New York");
        } else if (timeZone.equals("America/Chicago")) {
            cityLabel.setText("Chicago");
        } else if (timeZone.equals("America/Los_Angeles")) {
            cityLabel.setText("Los Angeles");
        } else {
        }
        ServerGeneratedMessageDateTimeServiceAsync theServerMessageGeneratorServiceAsync = RPCFactory.dateTimeService();
        //ServerGeneratedMessageDateTimeServiceAsync theServerMessageGeneratorServiceAsync = GWT.create(ServerGeneratedMessageDateTimeService.class);
        //America/Los_Angeles
        //America/New_York
        //America/Chicago
        theServerMessageGeneratorServiceAsync.start(new VoidAsyncCallback());
        /* Logic for GWTEventService starts here */
        //get the RemoteEventService for registration of RemoteEventListener instances
        RemoteEventService theRemoteEventService = RemoteEventServiceFactory.getInstance().getRemoteEventService();
        //add a listener to the SERVER_MESSAGE_DOMAIN
        theRemoteEventService.addListener(ServerGeneratedMessageDateTimeEvent.SERVER_MESSAGE_DOMAIN, new RemoteEventListener() {
            public void apply(Event anEvent) {
                if (anEvent instanceof ServerGeneratedMessageDateTimeEvent) {
                    ServerGeneratedMessageDateTimeEvent evt = (ServerGeneratedMessageDateTimeEvent) anEvent;
                    //log.info("evt="+evt.toString());
                    if (timeZone.equals("America/New_York")) {
                        //log.info("### createMessageGeneratorService timeZones NY");
                        dateLabel.setText(evt.getNyDateMessage());
                        timeLabel.setText(evt.getNyTimeMessage());
                    } else if (timeZone.equals("America/Chicago")) {
                        //log.info("### createMessageGeneratorService timeZones CG");
                        dateLabel.setText(evt.getCgDateMessage());
                        timeLabel.setText(evt.getCgTimeMessage());
                    } else if (timeZone.equals("America/Los_Angeles")) {
                        //log.info("### createMessageGeneratorService timeZones LA");
                        dateLabel.setText(evt.getLaDateMessage());
                        timeLabel.setText(evt.getLaTimeMessage());
                    } else {
                        //log.info("### createMessageGeneratorService timeZones UNKNOWN");
                    }
                }
            }
        });
        /* Logic for GWTEventService ends here */
    }

    private class VoidAsyncCallback implements AsyncCallback<Void> {
        public void onFailure(Throwable aThrowable) {
        }

        public void onSuccess(Void aResult) {
        }
    }

    public XClockComponent() {
        //#############################
        VBoxLayoutContainer layout = new VBoxLayoutContainer ();
        //#############################
        cityLabel.setText("Trenton");
        dateLabel.setText("11/18/2014");
        timeLabel.setText("12:04PM");
        //#############################
        cityLabel.setWordWrap(false);
        dateLabel.setWordWrap(false);
        timeLabel.setWordWrap(false);
        //#############################
        cityLabel.setStyleName("gwt-Clock-Label");
        dateLabel.setStyleName("gwt-Clock-Label");
        timeLabel.setStyleName("gwt-Clock-Label");
        //#############################
        layout.setVBoxLayoutAlign(VBoxLayoutContainer.VBoxLayoutAlign.CENTER);
        //#############################
        //Margins(int top, int right, int bottom, int left)
        layout.add(cityLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(15, 0, 0, 0)));
        layout.add(dateLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(2, 0, 0, 0)));
        layout.add(timeLabel, new BoxLayoutContainer.BoxLayoutData(new Margins(2, 0, 0, 0)));
        //#############################
        add(layout);
        //#############################
    }
}
