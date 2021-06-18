package com.example.esame.controller;

import com.example.esame.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test-esame")
    public String testEsame() {
        return testService.testEsame(2, 3);
    }

}
