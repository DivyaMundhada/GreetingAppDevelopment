/* UC-3:Ability for the Greeting App to give Greeting message with
 * 1. User First Name and Last Name
 * 2. With just First Name or Last Name based on User attributes provided
 * 3. Just Hello World.

 * @author DIVYA MUNDHADA
 * @since 16.08.2021
 */

package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.services.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingAppController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingAppService greetingAppService;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>(greetingAppService.getMessage(), HttpStatus.OK);
    }

    @GetMapping(value = "/getGreetingMessage")
    public ResponseEntity<String> greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                                           @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return new ResponseEntity<>(greetingAppService.getGreeting(firstName, lastName), HttpStatus.OK);
    }

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
