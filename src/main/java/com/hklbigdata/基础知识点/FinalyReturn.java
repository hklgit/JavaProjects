package com.hklbigdata.基础知识点;

/**
 * Created by Kerven-HAN on 2019/10/8 9:56.
 * Talk is cheap , show me the code
 *
 * 测试一下：finaly 和 return 的返回顺序问题
 */
public class FinalyReturn {


    public static void main(String[] args) {
//        测试是先执行return还是finaly

        System.out.println(getResult());

    }


    public static int getResult(){
        try{
            System.out.println("进入到try");
            int i = 100;
            System.exit(-1); //如果说jvm在try就退出了，那么也就废了。finally根本不会被执行了
            return i;
        }finally {
            System.out.println("进入到finally");
            return 100; //如果说finally也有return,那么会覆盖try里的return
        }
    }

}
