package org.demo.feature.web;

import org.demo.feature.dao.UserMapper;
import org.demo.feature.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list/all")
    public Object listAll() {
        return userMapper.selectByExample(new UserExample());
    }
}
