package com.koisoftware.monet.client.service;

import com.google.gwt.core.client.GWT;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by sb90320 on 11/27/2014.
 */
public final class RPCFactory {
    private static final Logger log = Logger.getLogger(RPCFactory.class.getName());

    public static LoginServiceAsync loginService() {
        return (LoginServiceAsync) getServiceByFeature(LoginServiceAsync.class.getName());
    }

    public static ServerGeneratedMessageDateTimeServiceAsync dateTimeService() {
        return (ServerGeneratedMessageDateTimeServiceAsync) getServiceByFeature(ServerGeneratedMessageDateTimeServiceAsync.class.getName());
    }

    public static Object createServiceByFeature(String featureName) {
        Object ret;
        if (featureName.equalsIgnoreCase(LoginServiceAsync.class.getName())) {
            ret = GWT.create(LoginService.class);
        } else if (featureName.equalsIgnoreCase(ServerGeneratedMessageDateTimeServiceAsync.class.getName())) {
            ret = GWT.create(ServerGeneratedMessageDateTimeService.class);
        } else {
            throw new RuntimeException("Service name doesn't exist: " + featureName);
        }
        return ret;
    }

    private static HashMap<String, Object> hm = new HashMap();

    public static Object getServiceByFeature(String featureName) {
        Object retService = null;
        if (featureName != null) {
            retService = hm.get(featureName);
            if (retService == null) {
                setServiceByFeature(featureName, null);
                retService = hm.get(featureName);
            }
        }
        return retService;
    }

    public static void setServiceByFeature(String featureName, Object rs) {
        if (featureName != null) {
            if (rs != null) {
                hm.put(featureName, rs);
                //log.info("New AsyncService registered for : featureName")
            } else {
                rs = createServiceByFeature(featureName);
                hm.put(featureName, rs);
                //log.info ("New AsyncService created for : featureName")
            }

        } else {
            //log.info ("Invalid featureName provided to register")
        }
    }
}
