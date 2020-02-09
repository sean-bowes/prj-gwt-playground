package com.koisoftware.monet.server.gwt;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//@WebServlet(
//        name = "springGwtRemoteServiceServlet",
//        urlPatterns = {"/monet/springGwtServices/*"},
//        asyncSupported = true
//        )
public class SpringGwtService extends RemoteServiceServlet {
    private static final Logger log = LoggerFactory.getLogger(SpringGwtService.class);

    @Override
    public String processCall(String payload) throws SerializationException {
        try {
            Object handler = getBean(getThreadLocalRequest());
            RPCRequest rpcRequest = RPC.decodeRequest(payload, handler.getClass(), this);
            onAfterRequestDeserialized(rpcRequest);

            log.debug("RPC: " + handler.getClass().getName() + "." + rpcRequest.getMethod().getName() + " " + Arrays.asList(rpcRequest.getParameters()));
            return RPC.invokeAndEncodeResponse(handler, rpcRequest.getMethod(), rpcRequest.getParameters(), rpcRequest.getSerializationPolicy());
        } catch (IncompatibleRemoteServiceException e) {
            log.error(e.getMessage(), e);
            return RPC.encodeResponseForFailure(null, e);
        }
    }

    protected Object getBean(HttpServletRequest request) {
        String url = request.getRequestURI();
        String name = url.substring(url.lastIndexOf("/") + 1);
        log.debug("RPC: url=" + url + ",name=" + name);

        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (applicationContext == null) {
            throw new IllegalStateException("No spring context found");
        }
        if (!applicationContext.containsBean(name)) {
            throw new IllegalArgumentException("Spring bean doesn't exist: " + name);
        }
        Object o = applicationContext.getBean(name);

        // if the service extends AbstractMonetService set the AuthenticatedUser
        /*
        if (o instanceof LoginService) {
            AuthenticatedUser user = (AuthenticatedUser) request.getSession(true).getAttribute(AppConstants.SESSION_AUTHENTICATED_USER);
            ((AbstractMonetService) o).setUser(user);
        }
        */
        return o;
    }

    @Override
    protected void doUnexpectedFailure(Throwable e) {
        try {
            log.error(e.getMessage(), e);
        } catch (Exception e1) {
            super.doUnexpectedFailure(e1);
        }
    }
}
