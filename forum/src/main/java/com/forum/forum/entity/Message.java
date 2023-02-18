package com.forum.forum.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name = "message")
public class Message {
    
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long MessageId;

    String sender;
  
    String message;

}
