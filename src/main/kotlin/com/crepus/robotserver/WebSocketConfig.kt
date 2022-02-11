package com.crepus.robotserver

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.*


@Configuration
@EnableWebSocket
class WebSocketConfig(private val motorStateHandler: MotorStateHandler, private val motorCmdHandler: MotorCmdHandler) :
    WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(motorStateHandler, "/motor-state").setAllowedOrigins("*")
        registry.addHandler(motorCmdHandler, "/motor-cmd").setAllowedOrigins("*")
        registry.addHandler(motorCmdHandler, "/motor-connection-state").setAllowedOrigins("*")
    }
}