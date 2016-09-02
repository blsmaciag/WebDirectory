package com.gft.challange.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

import static com.gft.challange.websocket.ResourceUri.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry handlerRegistry) {
        handlerRegistry.addEndpoint(ENDPOINT_MESSENGER.getUri()).withSockJS();
}

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes(APPLICATION_RESOURCE_PREFIX.getUri());
        registry.enableSimpleBroker(BROKER_TOPIC.getUri());
    }
}
