/**
 * UC-1: Using GreetingController return JSON for different HTTP Methods.
 *
 * @author DIVYA MUNDHADA
 * @since 16.08.2021
 */

package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingAppController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/getGreeting")
    public GreetingDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingDTO(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/postGreeting")
    public GreetingDTO sayHello(@RequestBody GreetingDTO greetingDTO) {
        return new GreetingDTO(counter.incrementAndGet(), String.format(template, greetingDTO.getContent()));
    }

    @PutMapping("/putGreeting/{counter}")
    public GreetingDTO sayHello(@PathVariable int counter, @RequestParam(value = "content") String contentName) {
        return new GreetingDTO(counter, String.format(template, contentName));
    }
}
