package org.demo.mybatis.spring.raw.service;

import org.demo.mybatis.spring.raw.entity.Goods;
import org.springframework.stereotype.Service;


@Service
public interface GoodsService {
    Goods getGood(long goodId);
}
