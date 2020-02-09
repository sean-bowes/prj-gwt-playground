package com.koisoftware.monet.server.service;

import com.koisoftware.monet.client.service.ServerGeneratedMessageDateTimeService;
import com.koisoftware.monet.client.service.event.ServerGeneratedMessageDateTimeEvent;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class ServerGeneratedMessageDateTimeServiceImpl extends RemoteEventServiceServlet implements ServerGeneratedMessageDateTimeService {
    private static final Logger log = Logger.getLogger(ServerGeneratedMessageDateTimeServiceImpl.class.getName());
    private Timer myEventGeneratorTimer;

    public synchronized void start() {
        //log.info("######################");
        //log.info("timer create id=" + Thread.currentThread().getId());
        if (myEventGeneratorTimer == null) {
            //log.info("######################");
            //log.info("timer initial create id=" + Thread.currentThread().getId());
            myEventGeneratorTimer = new Timer();
            // scheduling the task at interval (60 seconds)
            long delay = 1000;
            long period = 1000 * 30;
            myEventGeneratorTimer.scheduleAtFixedRate(new ServerMessageGeneratorDateTimeTimerTask(), delay, period);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (myEventGeneratorTimer != null) {
            //log.info("######################");
            //log.info("timer destroy id=" + Thread.currentThread().getId());
            //clean-up
            myEventGeneratorTimer.cancel();
            myEventGeneratorTimer.purge();
        }
    }

    private class ServerMessageGeneratorDateTimeTimerTask extends TimerTask {
        public void run() {
            //final String theEventMessage = getCurrentTimeFormatted();
            //create the event
            //Event theEvent = new ServerGeneratedMessageDateTimeEvent(theEventMessage);
            //log.info("######################");
            //log.info("timer run id=" + Thread.currentThread().getId() +
//                    ", nydate=" + getCurrentDateFormattedNy() + ", nytime=" + getCurrentTimeFormattedNy() +
//                    ", cgdate=" + getCurrentDateFormattedCg() + ", cgtime=" + getCurrentTimeFormattedCg() +
//                    ", ladate=" + getCurrentDateFormattedLa() + ", latime=" + getCurrentTimeFormattedLa());

            //Event theEvent = new ServerGeneratedMessageDateTimeEvent(
            ServerGeneratedMessageDateTimeEvent theEvent = new ServerGeneratedMessageDateTimeEvent(
                    getCurrentDateFormattedNy(), getCurrentTimeFormattedNy(),
                    getCurrentDateFormattedCg(), getCurrentTimeFormattedCg(),
                    getCurrentDateFormattedLa(), getCurrentTimeFormattedLa());
            //add the event, so clients can receive it
            //log.info("######################");
            //log.info("timer run event created and adding");
            //log.info("theEvent before="+theEvent.toString());
            addEvent(ServerGeneratedMessageDateTimeEvent.SERVER_MESSAGE_DOMAIN, theEvent);
            //log.info("theEvent after="+theEvent.toString());
        }
    }

    private String getCurrentDateFormattedNy() {
        SimpleDateFormat theDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        theDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return theDateFormat.format(Calendar.getInstance().getTime());
    }

    private String getCurrentTimeFormattedNy() {
        SimpleDateFormat theDateFormat = new SimpleDateFormat("hh:mma");
        theDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return theDateFormat.format(Calendar.getInstance().getTime());
    }

    private String getCurrentDateFormattedCg() {
        SimpleDateFormat theDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        theDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        return theDateFormat.format(Calendar.getInstance().getTime());
    }

    private String getCurrentTimeFormattedCg() {
        SimpleDateFormat theDateFormat = new SimpleDateFormat("hh:mma");
        theDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        return theDateFormat.format(Calendar.getInstance().getTime());
    }

    private String getCurrentDateFormattedLa() {
        SimpleDateFormat theDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        theDateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return theDateFormat.format(Calendar.getInstance().getTime());
    }

    private String getCurrentTimeFormattedLa() {
        SimpleDateFormat theDateFormat = new SimpleDateFormat("hh:mma");
        theDateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return theDateFormat.format(Calendar.getInstance().getTime());
    }

}
