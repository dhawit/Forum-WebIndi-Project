package com.forum.forum.pojo;

import com.forum.forum.entity.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    
    Long UserID;

    String username;

    @NotEmpty(message = "Username can't be empty")
    String email;

    @NotEmpty(message = "Username can't be empty")
    String password;

    public UserPojo(User user){
        this.UserID = user.getUserID();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
