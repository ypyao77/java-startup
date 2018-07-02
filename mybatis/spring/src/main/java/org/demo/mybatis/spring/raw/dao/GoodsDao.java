package org.demo.mybatis.spring.raw.dao;

import org.demo.mybatis.spring.raw.entity.Goods;

public interface GoodsDao {
    Goods getGoodByPrimaryKey(long goodId);
}
