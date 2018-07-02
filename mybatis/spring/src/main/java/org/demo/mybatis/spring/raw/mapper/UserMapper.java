package org.demo.mybatis.spring.raw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.demo.mybatis.spring.raw.entity.User;


public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{userId}")
    User getUser(@Param("userId") String userId);
}
