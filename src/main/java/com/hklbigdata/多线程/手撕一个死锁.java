package com.hklbigdata.多线程;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kerven on 2019/6/12.
 * <p>
 * 　　　　　　　   ┏┓　   ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ +
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Don't bibi , show me the code
 * 手写一个死锁
 * 为了便于后期复习所以类名就这么粗放了 哈哈
 * jps
 * jstack
 * jconsole
 * all theses tools can be used to analyze dead lock
 */
public class 手撕一个死锁 {


    public static void main(String[] args) {


        //1:先来两把锁
        final Object lock01 =  new Object();
        final Object lock02 =  new Object();

        //2:create thread01
        Thread thread01= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock01){
                    System.out.println(Thread.currentThread().getName()+"hold lock01 now ,wanted to get lock02");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lock02){
                        System.out.println(Thread.currentThread().getName()+"hold lock02 now ,wanted to get lock01");
                    }
                }
            }
        },"thread01");
        //3:create thread01
        Thread thread02= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock02){
                    System.out.println(Thread.currentThread().getName()+"hold lock02 now ,wanted to get lock01");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lock01){
                        System.out.println(Thread.currentThread().getName()+"hold lock01 now ,wanted to get lock02");
                    }
                }
            }
        },"thread02");

        thread01.start();
        thread02.start();

    }
}











