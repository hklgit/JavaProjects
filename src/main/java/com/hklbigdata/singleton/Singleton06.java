package com.hklbigdata.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/7/27 21:04
 * Talk is cheep , show me the code
 *
 * 静态内部类的方式来完成，
 * 1：保证了懒加载
 * 2：保证了只创建一次
 * 3：不加锁，效率高
 */
public class Singleton06 {

    private Singleton06(){};

    private  static  class InstaceHolder{
        private static  final  Singleton06 instance = new Singleton06();
    }

    public  Singleton06 getInstance(){
        return InstaceHolder.instance;
    }

}
