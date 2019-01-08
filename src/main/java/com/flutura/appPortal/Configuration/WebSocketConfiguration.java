package com.flutura.appPortal.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;

@Configuration
public class WebSocketConfiguration extends WebSocketMessageBrokerConfigurationSupport{
    @Override
    protected void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {

        stompEndpointRegistry.addEndpoint("/websocket")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    protected void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic","/test");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
