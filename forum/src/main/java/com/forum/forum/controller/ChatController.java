package com.forum.forum.controller;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.forum.forum.model.ChatMessage;
import com.forum.forum.services.MessageService;
import com.forum.forum.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ChatController {

    private final MessageService service;

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        service.save(chatMessage.getSender(), chatMessage.getContent());
        return chatMessage;
    }

    @PostMapping("/deleteMessage")
    public String deleteMessage(String messageId){
        service.delete(Long.parseLong(messageId));
        return("redirect:/home");
    }

}
