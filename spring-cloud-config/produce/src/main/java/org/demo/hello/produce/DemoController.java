package org.demo.hello.produce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/")
public class DemoController {
    //获取配置中心的属性
    @Value("${host.ifs}")
    private String ifsHost;

    @GetMapping("/host")
    public String host(){
        return this.ifsHost;
    }
}
