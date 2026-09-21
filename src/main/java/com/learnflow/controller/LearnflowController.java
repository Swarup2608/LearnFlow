package com.learnflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnflowController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Learnflow!";
    }
}