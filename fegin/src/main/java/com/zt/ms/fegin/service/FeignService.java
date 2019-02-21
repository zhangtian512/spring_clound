package com.zt.ms.fegin.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="service-controller")
public interface FeignService {

    @RequestMapping(value="main")
    String getFeignMain();
}
