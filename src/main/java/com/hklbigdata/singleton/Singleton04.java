package com.hklbigdata.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/7/27 21:04
 * Talk is cheep , show me the code
 * 懒汉式
 */
public class Singleton04 {
    private static Singleton04 instance;
    private Singleton04(){};
    public synchronized static Singleton04 getInstance(){
        if( null == instance ){
            synchronized (Singleton02.class){
                if( null == instance ){
                    return  new Singleton04();
                }
            }
        }
        return Singleton04.instance;
    }

}
