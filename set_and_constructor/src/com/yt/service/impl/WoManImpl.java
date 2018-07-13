package com.yt.service.impl;

import com.yt.dao.ManDao;
import com.yt.dao.WoManDao;
import com.yt.service.ManService;
import com.yt.service.WoManService;

public class WoManImpl implements WoManService {


    private WoManDao woManDao;

    //set注入
    public void setWoManDao(WoManDao woManDao) {
        this.woManDao = woManDao;
    }

    //set实现
    @Override
    public void eat(String str) {
        System.out.println("Service接收数据：" + str);
        woManDao.eat(str);
    }


}
