package com.hand.ssm.mapper;

import java.util.List;

import com.hand.ssm.entity.User;
import org.apache.ibatis.annotations.*;


public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{userId}")
    User getUser(@Param("userId") String userId);
}
