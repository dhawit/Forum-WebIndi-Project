package com.forum.forum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forum.forum.entity.Message;
import com.forum.forum.repository.MessageRepository;
import com.forum.forum.services.MessageService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repo;
    
    @Override
    public void save(String sender, String content) {
        Message message;
        message = new Message();
        message.setMessage(content);
        message.setSender(sender);
        repo.save(message);
    }

    @Override
    public List<Message> retrieve() {
        List<Message> result = repo.findAll();
        return(result);
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
