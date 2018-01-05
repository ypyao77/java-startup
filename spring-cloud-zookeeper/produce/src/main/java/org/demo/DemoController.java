package org.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/demo")
public class DemoController {
    private static final UUID INSTANCE_UUID = UUID.randomUUID();
    @Value("${source.name}")
    private String sourceName;

    @GetMapping(value = "/instance")
    public Object instance() {
        return sourceName + ": "  + INSTANCE_UUID.toString();
    }
}
