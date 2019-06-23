package com.hklbigdata.多线程.singleton;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/6/23 14:51
 * Talk is cheep , show me the code
 *
 * instance = new DCLModel();
 *
 * a:分配内存空间
 * b：实例化
 * c:instance引用指向分配的内存地址
 *
 * a,c 是有可能被指令重排序的
 *
 *
 */
public class DCLModel {

    private static volatile  DCLModel instance;

    private DCLModel() {
        System.out.println("begin create dcl");
    }


    public static DCLModel getInstance() {
        if (instance == null) {
            synchronized (DCLModel.class) {
                if (instance == null) {
                    instance = new DCLModel();
                }
            }
        }

        return instance;
    }
}
