package com.group.leavemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LeavemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeavemanagementApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String Hello()
    {
        return "Hello World";
    }

}
