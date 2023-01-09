package com.example.COVID19.controller;

import com.example.COVID19.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/covid")
public class CovidController {

    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

    @GetMapping("/saveFromApi")
    public List saveFromApi() throws Exception{
        return testService.saveFromApi();
    }

    @GetMapping("get/listPage")
    public Object getListPage(
            @RequestParam("index")int index,
            @RequestParam("size")int size,
            @RequestParam(value = "startCreateDt",required = false)String startCreateDt,
            @RequestParam(value ="endCreateDt",required = false)String endCreateDt
    ) throws Exception{
        return testService.getListPage(index,size,startCreateDt,endCreateDt);
    }


}