package com.zt.ms.ribbon.controller;

import com.zt.ms.ribbon.service.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @Autowired
    mainService ser;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value="getport")
    public String getport(){
        return "ribbon"+port;
    }

    @RequestMapping(value="getmain",method = RequestMethod.GET)
    public String getmain(){
        System.out.println("++++++");
        return ser.doMain();
    }
}
