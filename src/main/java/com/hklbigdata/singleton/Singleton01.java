package com.hklbigdata.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/7/27 21:02
 * Talk is cheep , show me the code
 * 饿汉式
 */
public class Singleton01 {
    private static  final Singleton01 instance = new Singleton01();
    private Singleton01(){};
    public Singleton01 getInstance(){
        return instance;

    }


}
