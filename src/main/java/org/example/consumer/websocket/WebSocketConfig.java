package org.example.consumer.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // React 애플리케이션에서 접근할 수 있도록 CORS 허용
        registry.addEndpoint("/ws-aircraft")
                .setAllowedOriginPatterns("*") // 모든 원본 허용 (프로덕션에서는 특정 도메인으로 제한하는 것이 좋습니다)
                .withSockJS(); // SockJS 지원 추가
        
        // SockJS를 사용하지 않는 순수 WebSocket 엔드포인트도 추가
        registry.addEndpoint("/ws-aircraft")
                .setAllowedOriginPatterns("*");
    }
}