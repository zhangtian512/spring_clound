package com.zt.ms.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class mainService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "HystrixFallBack")
    public String doMain(){
        return restTemplate.getForObject("http://controller/main",String.class);
    }

    public String HystrixFallBack(){
        return " service is down";
    }
}
