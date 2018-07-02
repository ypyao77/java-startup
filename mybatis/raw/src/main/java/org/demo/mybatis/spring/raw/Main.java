package org.demo.mybatis.spring.raw;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.demo.mybatis.spring.raw.entity.User;
import org.demo.mybatis.spring.raw.mapper.UserMapper;

public class Main {
    public static void main(String[] args) {
        ApplicationContext atc = new ClassPathXmlApplicationContext("spring.xml");
        UserMapper userMapper = (UserMapper) atc.getBean("userMapper");
        List<User> users = userMapper.getAll();

        for(User user: users) {
            System.out.println(user);
        }
    }
}
