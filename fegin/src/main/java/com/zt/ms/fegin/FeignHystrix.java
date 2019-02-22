package com.zt.ms.fegin;

import com.zt.ms.fegin.service.FeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignHystrix implements FallbackFactory<FeignService> {

    @Override
    public FeignService create(Throwable cause){
        return new FeignService(){
            @Override
            public String getFeignMain(){
                return "Feign service is down cause:"+cause;
            }
        };
    }

}
