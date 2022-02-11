package com.crepus.robotserver


import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.ConcurrentHashMap

class MotorConnectionStateHandler : TextWebSocketHandler() {
    companion object {
        @JvmStatic
        val sessions = ConcurrentHashMap<String, WebSocketSession>()
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions[session.id] = session
    }

    override fun handleTextMessage(
        session: WebSocketSession,
        message: TextMessage
    ) {
        val payload = message.payload
        println("MotorCmd: $payload")
        // 广播
        sessions.forEach { (_, value) ->
            value.sendMessage(TextMessage(payload))
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session.id)
    }

}