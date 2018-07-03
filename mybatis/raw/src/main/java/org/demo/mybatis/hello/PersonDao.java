package org.demo.mybatis.hello;

import java.util.List;

public interface PersonDao {
    Person findById(int id) throws Exception;

    List<Person> findAll() throws Exception;
}
