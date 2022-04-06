package com.example.COVID19.controller;

import com.example.COVID19.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/covid")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

    @GetMapping("/all")
    public List getAllData() throws Exception{
        return testService.getAllData();
    }


}