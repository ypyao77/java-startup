package org.demo.mybatis.hello;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDaoImpl impl = new PersonDaoImpl();

        try {
            System.out.println("calling findAll()");
            List<Person> persons = impl.findAll();
            for (Person p: persons) {
                System.out.println(p);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("calling findById(2)");
            Person p = impl.findById(2);
            System.out.println(p);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
