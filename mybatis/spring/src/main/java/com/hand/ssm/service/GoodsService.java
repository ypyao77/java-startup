package com.hand.ssm.service;

import org.springframework.stereotype.Service;
import com.hand.ssm.entity.Goods;

@Service
public interface GoodsService {
    Goods getGood(long goodId);
}
