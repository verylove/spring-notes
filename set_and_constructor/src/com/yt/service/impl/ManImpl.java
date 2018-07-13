package com.yt.service.impl;

import com.yt.dao.ManDao;
import com.yt.dao.WoManDao;
import com.yt.service.ManService;

public class ManImpl implements ManService {


    private ManDao manDao;


    //构造注入
    public ManImpl(ManDao manDao){
        this.manDao = manDao;
    }

    //构造实现
    @Override
    public void eatByConstructor(String str) {
        System.out.println("Constructor Service接收数据："+str);
        manDao.eat(str);
    }



}
