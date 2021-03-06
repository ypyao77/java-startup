package org.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/demo")
public class DemoController {

    private static final UUID INSTANCE_UUID = UUID.randomUUID();

    // 方法1
    @Autowired
    private DemoService remoteService;

    // 方法2
    /*
    private final DemoService remoteService;

    public DemoController(final DemoService remoteService) {
        this.remoteService = remoteService;
    }
    */

    @GetMapping(value = "/remote-instance")
    public Object remoteInstance() {
        return this.remoteService.instance();
    }

    @GetMapping(value = "/instance")
    public Object instance() {
        return INSTANCE_UUID.toString();
    }
}
