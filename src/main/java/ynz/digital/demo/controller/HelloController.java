package ynz.digital.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${welcome.msg}")
    private String welcomeMsg;

    @GetMapping("/")
    public String sayHello()
    {
        return welcomeMsg;
    }
}
