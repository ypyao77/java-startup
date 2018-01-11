package org.demo.hello.consume;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="hello-zuul-service", fallback=ConsumeService.HystrixConsumeService.class)
public interface ConsumeService {
    @RequestMapping(value="/ccall/hello", method=RequestMethod.GET)
    String hello(@RequestParam("token") String token);

    @Component
    class HystrixConsumeService implements ConsumeService {
        @Override
        public String hello(@RequestParam("token") String token) {
            return "-999";
        }
    }
}
