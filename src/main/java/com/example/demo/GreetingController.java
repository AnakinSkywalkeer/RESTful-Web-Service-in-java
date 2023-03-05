package com.example.demo;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@RestController
public class GreetingController {
    private static final String template="Hello %s!";
    private final AtomicLong counter= new AtomicLong();

    @GetMapping("/")
    public Greeting greeting(@RequestParam(value="name",defaultValue="world") String name){
        return  new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
    @GetMapping("/error")
    public Greeting error(@RequestParam(value="name",defaultValue="world") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
