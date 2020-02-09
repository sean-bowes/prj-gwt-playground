package com.koisoftware.monet.client.service.event;

import de.novanic.eventservice.client.event.Event;
import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;

public class ServerGeneratedMessageDateTimeEvent implements Event {

    public static final Domain SERVER_MESSAGE_DOMAIN = DomainFactory.getDomain("clock_server_message_domain");
    private String nyDateMessage;
    private String nyTimeMessage;
    private String cgDateMessage;
    private String cgTimeMessage;
    private String laDateMessage;
    private String laTimeMessage;

    public ServerGeneratedMessageDateTimeEvent() {
    }

    public ServerGeneratedMessageDateTimeEvent(String aNyDateMessage, String aNyTimeMessage,
                                               String aCgDateMessage, String aCgTimeMessage,
                                               String aLaDateMessage, String aLaTimeMessage) {
        nyDateMessage = aNyDateMessage;
        nyTimeMessage = aNyTimeMessage;
        cgDateMessage = aCgDateMessage;
        cgTimeMessage = aCgTimeMessage;
        laDateMessage = aLaDateMessage;
        laTimeMessage = aLaTimeMessage;
    }

    public String toString() {
        StringBuilder theStringBuilder = new StringBuilder(100);
        theStringBuilder.append(ServerGeneratedMessageDateTimeEvent.class.getName());
        theStringBuilder.append(", nydate=" + getNyDateMessage() + ", nytime=" + getNyTimeMessage());
        theStringBuilder.append(", cgdate=" + getCgDateMessage() + ", cgtime=" + getCgTimeMessage());
        theStringBuilder.append(", ladate=" + getLaDateMessage() + ", latime=" + getLaTimeMessage());
        return theStringBuilder.toString();
    }

    public String getNyDateMessage() {
        return nyDateMessage;
    }

    public String getNyTimeMessage() {
        return nyTimeMessage;
    }

    public String getCgDateMessage() {
        return cgDateMessage;
    }

    public String getCgTimeMessage() {
        return cgTimeMessage;
    }

    public String getLaDateMessage() {
        return laDateMessage;
    }

    public String getLaTimeMessage() {
        return laTimeMessage;
    }
}
