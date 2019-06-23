package com.hklbigdata.多线程.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/6/23 18:34
 * Talk is cheep , show me the code
 */
public class EnumSingletonModel {

    private EnumSingletonModel(){}


    /**
     * 使用枚举来创建我们的单例
     * 构造器是默认被调用的
     * 且是thread safe
     */
    private enum Singleton{
        INSTANCE;
        private final EnumSingletonModel instance;
        Singleton(){
            instance = new EnumSingletonModel();
        }

        public EnumSingletonModel getInstance(){
            return instance;
        }
    }


    public static EnumSingletonModel getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

}
