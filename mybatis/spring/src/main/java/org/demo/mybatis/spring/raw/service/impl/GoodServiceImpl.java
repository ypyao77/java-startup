package org.demo.mybatis.spring.raw.service.impl;

import org.demo.mybatis.spring.raw.dao.GoodsDao;
import org.demo.mybatis.spring.raw.entity.Goods;
import org.demo.mybatis.spring.raw.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;


public class GoodServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public Goods getGood(long goodId) {
        return goodsDao.getGoodByPrimaryKey(goodId);
    }
}
