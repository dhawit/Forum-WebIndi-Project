package com.forum.forum.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class ChatMessage {

    private String content;
    private String sender;
    private MessageType type;
    private String time;
    
    public enum MessageType{
        AUTH_FAIL, JOIN_REQ,CHAT,JOIN,LEAVE
    }

    public void setContent(String content){
       this.content = content;
    }

    public String getContent(){
        return content;
    }
    
    public void setSender(String sender){
        this.sender = sender;
    }

    public String getSender(){
        return sender;
    }

    public MessageType getType(){
       return type;
    }

    public void setType(MessageType type){
        this.type = type;
    }

    public String getTime(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("hh:mm:a");
        time = localTime.format(myFormatter).toString();
        return time;
    }

    


    
}   
