package org.demo.mybatis.spring.raw.test;

import org.demo.mybatis.spring.raw.dao.GoodsDao;
import org.demo.mybatis.spring.raw.entity.Goods;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        GoodsDao goodsDao = (GoodsDao) context.getBean("goodsDao");
        Goods goods = goodsDao.getGoodByPrimaryKey(1000);
        System.out.println(goods);
    }
}
