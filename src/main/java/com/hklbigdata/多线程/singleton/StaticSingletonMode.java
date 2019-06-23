package com.hklbigdata.多线程.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/6/23 18:28
 * Talk is cheep , show me the code
 *
 * 使用静态内部类来实现
 */
public class StaticSingletonMode {

    private StaticSingletonMode(){}

    private static class InstanceHold{
        private static final StaticSingletonMode instance = new StaticSingletonMode();
    }

    public static StaticSingletonMode getInstance(){
        return  InstanceHold.instance;
    }

}
