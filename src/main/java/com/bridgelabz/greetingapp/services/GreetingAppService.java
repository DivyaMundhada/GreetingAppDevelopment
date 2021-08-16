package com.bridgelabz.greetingapp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingAppService {
    public String getMessage() {
        return "Hello World";
    }
}
