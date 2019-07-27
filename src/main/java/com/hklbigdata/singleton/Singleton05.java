package com.hklbigdata.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/7/27 21:04
 * Talk is cheep , show me the code
 * DCL方式
 * 如果说不加 volatile  有可能会引起空指针问题
 */
public class Singleton05 {

    private volatile static Singleton05 instance;
    private Singleton05(){};
    public synchronized static Singleton05 getInstance(){
       // 这个判断可以提升效率
        if( null == instance ){
            synchronized (Singleton02.class){
                if( null == instance ){
                        return  new Singleton05();
                }
            }
        }
        return Singleton05.instance;
    }

}
