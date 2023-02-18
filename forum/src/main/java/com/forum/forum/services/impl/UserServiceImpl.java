package com.forum.forum.services.impl;

import org.springframework.stereotype.Service;

import com.forum.forum.config.PasswordEncoderUtil;
import com.forum.forum.entity.User;
import com.forum.forum.pojo.UserPojo;
import com.forum.forum.repository.UserRepository;
import com.forum.forum.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override 
    public UserPojo save(UserPojo userPojo){
        User user;
        if(userPojo.getUserID() != null){
            user = userRepository.findById(userPojo.getUserID()).orElseThrow(() -> new RuntimeException("Not Found"));
        }
        else{
            user = new User();
        }
        user.setEmail(userPojo.getEmail());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        user.setUsername(userPojo.getUsername());

        userRepository.save(user);
        return new UserPojo(user);
    }

    @Override 
    public Integer update(UserPojo userPojo){
        Integer status = userRepository.updatePassword(userPojo.getPassword(), userPojo.getEmail());
        return(status);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    
}
