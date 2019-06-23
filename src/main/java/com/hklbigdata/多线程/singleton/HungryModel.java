package com.hklbigdata.多线程.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/6/23 14:43
 * Talk is cheep , show me the code
 *
 * 饿汉式
 */
public class HungryModel {

    private  static final HungryModel instance = new HungryModel();
    private HungryModel(){

    }

    public static  HungryModel getInstance(){
        return instance;
    }

}
