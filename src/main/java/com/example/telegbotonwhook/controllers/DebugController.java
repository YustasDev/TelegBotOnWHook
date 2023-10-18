package com.example.telegbotonwhook.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @GetMapping("/wh/test")
    public String getTestMessage() {
        return "Everything is fine, beautiful Marquise!";
    }

}
