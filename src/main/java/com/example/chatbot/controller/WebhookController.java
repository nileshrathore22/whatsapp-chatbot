package com.example.chatbot.controller;

import com.example.chatbot.model.MessageRequest;
import com.example.chatbot.model.MessageResponse;
import com.example.chatbot.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private ChatService chatService;

    @PostMapping
    public MessageResponse handleMessage(@RequestBody MessageRequest request) {
        logger.info("Received POST /webhook with message: {}", request.getMessage());

        String reply = chatService.getReply(request.getMessage());

        logger.info("Reply: {}", reply);
        return new MessageResponse(reply);
    }
}
