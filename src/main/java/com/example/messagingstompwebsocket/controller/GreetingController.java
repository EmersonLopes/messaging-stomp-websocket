package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.model.Greeting;
import com.example.messagingstompwebsocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay

        Greeting greeting = new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        System.out.println(greeting);
        return greeting;
    }

    /*
    * to connect to server:         /gs-guide-websocket
    * to send message:              /app/hello
    *
    * to subscribe so that
    * we can receive messages:      /topic/greetings
    * */

}

