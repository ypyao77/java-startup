package org.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo-service", path = "/api/demo")
public interface DemoService {
    @GetMapping(value = "/instance")
    String instance();
}
