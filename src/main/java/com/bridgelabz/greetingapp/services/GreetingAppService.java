package com.bridgelabz.greetingapp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingAppService {

    private static final String template = "Hello, %s %s!";

    public String getMessage() {
        return "Hello World";
    }

    public String getGreeting(String firstName, String lastName) {
        return String.format(template, firstName, lastName);
    }
}
