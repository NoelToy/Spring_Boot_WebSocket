package com.flutura.appPortal.Controller;

import com.flutura.appPortal.Model.User;
import com.flutura.appPortal.Model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user){
        return new UserResponse("Hello "+user.getName());
    }

    @MessageMapping("/chat")
    @SendTo("/test/queue")
    public UserResponse someUser(User user){
        return new UserResponse("Hai "+user.getName());
    }
}

