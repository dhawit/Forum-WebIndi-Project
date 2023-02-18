package com.forum.forum.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.forum.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long>{
    
}
