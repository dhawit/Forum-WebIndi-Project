package com.forum.forum.services;

import com.forum.forum.entity.User;
import com.forum.forum.pojo.UserPojo;

public interface UserService {
    
    UserPojo save(UserPojo userPojo);
    Integer update(UserPojo userPojo);
    void deleteById(Long id);
}
