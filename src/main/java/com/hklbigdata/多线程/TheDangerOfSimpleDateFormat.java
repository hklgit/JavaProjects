package com.hklbigdata.多线程;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kerven on 2019/6/20.
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
 *
 * the danger of simpledataformat in multithreading
 *
 * 八一八他的那些事儿
 *
 * 怎么破？
 * 阿里的开发手册里建议使用ThreadLocal，上锁影响效率
 */
public class TheDangerOfSimpleDateFormat {


    /*
    各种报错：
    java.lang.NumberFormatException: For input string: ""

     */

    //(1)创建单例实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //(2)创建多个线程，并启动
        for (int i = 0; i <10 ; ++i) {
            Thread thread = new Thread(new Runnable() {
               @Override
                public void run() {
                    try {//(3)使用单例日期实例解析文本
                        System.out.println(sdf.parse("2019-06-13 15:17:27"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();//(4)启动线程
        }
    }


}

class ResolveTheProblem{

//阿里开发手册推荐我们
    private static  final  ThreadLocal<DateFormat> df =  new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue() {
           return  new SimpleDateFormat("yyyy-MM-hh");
        }
    };

    public static void main(String[] args) {

    }
}











