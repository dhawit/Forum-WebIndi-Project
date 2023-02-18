package com.forum.forum.SecurityContext;

import org.springframework.security.core.context.SecurityContextHolder;

import com.forum.forum.entity.User;

public class Context {
    
    public static String getUser(){
        String user;
        Object Principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if( Principal instanceof User ){
            user = ((User) Principal).getUsername();
        }
        else{
            user = Principal.toString();
        }
        return user;
    }
    public static Long getID(){
        Long user = null;
        Object Principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if( Principal instanceof User ){
            user = ((User) Principal).getUserID();
        }
        else{
        }
        return user;
    }
    
}
