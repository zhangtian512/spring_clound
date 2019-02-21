package com.zt.ms.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class mainService {

    @Autowired
    RestTemplate restTemplate;

    public String doMain(){
        return restTemplate.getForObject("http://SERVICE-CONTROLLER/main",String.class);
    }
}
