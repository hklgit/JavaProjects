package com.hklbigdata.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/7/27 21:04
 * Talk is cheep , show me the code
 * 懒汉式
 */
public class Singleton03 {
    private static Singleton03 instance;
    private Singleton03(){};
    public synchronized static Singleton03 getInstance(){
        if( null == instance ){
            return  new Singleton03();
        }
        return Singleton03.instance;
    }


}
