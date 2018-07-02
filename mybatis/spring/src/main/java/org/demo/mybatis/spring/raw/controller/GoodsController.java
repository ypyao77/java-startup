package org.demo.mybatis.spring.raw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.mybatis.spring.raw.dao.GoodsDao;
import org.demo.mybatis.spring.raw.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("/good")
    public String getGood(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
        long id = Long.valueOf(request.getParameter("id"));

        Goods goods = goodsDao.getGoodByPrimaryKey(id);
        modelAndView.addObject("good", goods);
        return "success";
    }
}
