package org.demo.mybatis.spring.raw.mapper;

import java.util.List;
import org.demo.mybatis.spring.raw.entity.User;

public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
