package com.hklbigdata.基础知识点;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Kerven-HAN on 2019/10/10 11:05.
 * Talk is cheap , show me the code
 */
public class StringBuilderDemo {


    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer  = new StringBuffer();
        ConcurrentHashMap<String,String> curHap = new ConcurrentHashMap<String,String>();
//        ConcurrentHashMap<String,String>
        for (int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++){
                        stringBuilder.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(stringBuilder.length());
    }
}
