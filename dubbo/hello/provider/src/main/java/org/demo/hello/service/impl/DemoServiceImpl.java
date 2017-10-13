package org.demo.hello.service.impl;

import org.demo.hello.service.DemoService;

/**
 * DemoService实现
 * <p>
 * Created by eagle on 15/9/30.
 */
public class DemoServiceImpl implements DemoService {

    /**
     * 测试方法 - 实现
     *
     * @param name
     * @return
     */
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
