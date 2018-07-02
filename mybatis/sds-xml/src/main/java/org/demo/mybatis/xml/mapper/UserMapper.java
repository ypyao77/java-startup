package org.demo.mybatis.xml.mapper;

import org.demo.mybatis.xml.entity.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);
}