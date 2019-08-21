package com.trilogyed.randomgreetingservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class RandomGreetingServiceController {
    private List<String> greetingList = new ArrayList<>();
    private Random rand = new Random();
    public RandomGreetingServiceController(){
        greetingList.add("Heya!");
        greetingList.add("Hello!");
        greetingList.add("Greetings!");
        greetingList.add("Sup!");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRandomGreeting(){
        return greetingList.get(rand.nextInt(4));
    }
}
