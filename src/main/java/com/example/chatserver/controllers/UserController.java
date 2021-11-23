package com.example.chatserver.controllers;

import com.example.chatserver.models.User;
import com.example.chatserver.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity createNewUser(@RequestBody User user)
    {
        user = userService.addNewUser(user);
        if(user == null)
        {
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }
        user.setPassword(null);
        return new ResponseEntity(user, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        User user = userService.validate(email, password);
        if(user == null)
        {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        user.setPassword(null);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
