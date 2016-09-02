package com.gft.challange.websocket;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
public class WebsocketConnectEvent implements ApplicationListener<SessionConnectEvent>{

    private static Logger LOG = Logger.getLogger(WebsocketConnectEvent.class);

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        LOG.info("::: Client Connected: "+sessionConnectEvent.getSource());
    }
}
