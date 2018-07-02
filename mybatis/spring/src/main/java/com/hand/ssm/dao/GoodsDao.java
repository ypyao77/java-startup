package com.hand.ssm.dao;

import com.hand.ssm.entity.Goods;

public interface GoodsDao {
    Goods getGoodByPrimaryKey(long goodId);
}
