package com.hklbigdata.算法;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/6/11 22:57
 * Talk is cheep , show me the code
 *
 * 实现字符串的反转,实现的方式有很多，我个人感觉这个比较不错
 * a=a^ b
 * b=a^ b
 * a=a^ b
 *
 *
 * */
public class ReverseString {
    public static void main(String[] args) {

        String str = "helloworld";
        System.out.println(reverseStr(str));


    }

    public static String reverseStr(String str){

        //1:先判断传入的参数是否合法
        if( str.length()==0 || str==null )return  str;
        //2:开始反转，我们利用的是位运算
        char[] arr = str.toCharArray();
        int len = str.length()-1;
        for (int i = 0; i < len; i++,len--) {
            arr[i]^=arr[len];
            arr[len]^=arr[i];
            arr[i]^=arr[len];
        }

        return  new String(arr);
    }


}
