package com.hklbigdata.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/7/27 21:04
 * Talk is cheep , show me the code
 * 懒汉式
 */
public class Singleton02 {
    private static  Singleton02 instance;
    private Singleton02(){};
    public  static Singleton02 getInstance(){
        if( null == instance ){
            return  new Singleton02();
        }
        return Singleton02.instance;
    }


}
