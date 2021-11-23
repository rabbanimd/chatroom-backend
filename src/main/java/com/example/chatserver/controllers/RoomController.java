package com.example.chatserver.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @MessageMapping("/create")
    @SendTo("/start/room")
    public String createNewRoom(String code)
    {

        return null;
    }
}
