package org.demo.hello.consume;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="hello-produce-service")
interface ConsumeService {
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    String hello();
}

