package com.zt.ms.fegin.controller;

import com.zt.ms.fegin.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value="getFeignMain")
    public String getFeignMain(){
        System.out.println("+++++++++");
        return feignService.getFeignMain();
    }
}
