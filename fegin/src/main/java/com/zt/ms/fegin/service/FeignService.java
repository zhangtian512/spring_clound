package com.zt.ms.fegin.service;

import com.zt.ms.fegin.FeignHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="service-controller",fallbackFactory = FeignHystrix.class)
public interface FeignService {

    @RequestMapping(value="main")
    String getFeignMain();
}
