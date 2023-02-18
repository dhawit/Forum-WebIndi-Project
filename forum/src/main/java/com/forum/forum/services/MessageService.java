package com.forum.forum.services;

import java.util.List;

import com.forum.forum.entity.Message;

public interface MessageService{
    
    void save(String sender, String content);

    List<Message> retrieve();

    void delete(Long id);
    
}
