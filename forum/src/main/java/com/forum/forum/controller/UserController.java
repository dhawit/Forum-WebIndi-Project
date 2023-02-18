package com.forum.forum.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.forum.forum.SecurityContext.Context;
import com.forum.forum.Utils.ImageUtil;
import com.forum.forum.pojo.UserPojo;
import com.forum.forum.repository.UserRepository;
import com.forum.forum.services.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String getIndex(){
        return("redirect:/login");
    }
    
    @GetMapping("/resetPassword")
    public String getRegisterPage(){
        return("resetPassword");
    }

    @GetMapping("/registerPage")
    public String getResetPassword(){
        return("register");
    }

    @PostMapping("/reset")
    public String reset(@Valid UserPojo userPojo, Model model){
        try{
            userService.update(userPojo);
            model.addAttribute("message", "Your Password has been changed");
            return("login");
        }
        catch(Exception e){
            e.printStackTrace();
            return("redirect:/");
        }
    }


    @PostMapping("/register")
    public String register(@Valid UserPojo userPojo, Model model){
        try{
            userService.save(userPojo);
            model.addAttribute("message", "Successfully Registered");
            return("login");
        }
        catch(Exception e){
            e.printStackTrace();
            return("redirect:/registerPage");
        }
    }
    @PostMapping(value = "/uploadProfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadBook(@RequestPart(name = "icon") MultipartFile icon,Model model) throws IOException, ServletException {
        ImageUtil imageUtil = new ImageUtil();
        Integer status = imageUtil.store(icon, Context.getUser());
        return("redirect:/home");
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(){
        userService.deleteById(Context.getID());
        return("redirect:/login");
    }

}
