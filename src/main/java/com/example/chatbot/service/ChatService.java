package com.example.chatbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);

    public String getReply(String message) {
        logger.info("Incoming message: {}", message);

        if (message == null) return "Invalid message";

        message = message.toLowerCase().trim();

        if (message.contains("hi") || message.contains("hello")) return "Hello";
        if (message.contains("bye")) return "Goodbye";

        return "I don't understand that message.";
    }
}
