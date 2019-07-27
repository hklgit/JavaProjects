package com.hklbigdata.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/7/27 21:04
 * Talk is cheep , show me the code
 *
 *
 * 使用枚举的方式。这个方式也是effective java 里作为推荐的方式
 *
 * 枚举的构造器也是只会被加载一次
 *
 */
public class Singleton07 {

    private Singleton07(){};

   private enum Singleton{
       INSTANCE;
       private final Singleton07 instance;
       Singleton(){
           instance = new Singleton07();
       }
       public Singleton07 getInstance(){
           return instance;
       }
    }

    public Singleton07 getInstance(){

       return Singleton.INSTANCE.getInstance();
    }

}
