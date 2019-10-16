package com.hklbigdata.算法.排序算法;

import java.util.Arrays;

/**
 * Created by Kerven-HAN on 2019/10/16 15:06.
 * Talk is cheap , show me the code
 */
public class XuanZeSort {

    public static void main(String[] args) {
        int[] arr = {1, 23, 4, 5, 6, 7, 22, 333, 6745, 13343};

        System.out.println(Arrays.toString(arr));



        int a = 123;
        int b = 456;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        System.out.println("a = " + a + "b = " + b);


    }




    //元素和其他的所有元素最对比
//    最外层的循环控制了我们拿出来比对的数，内层循环控制了我们要跟谁比
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
//                这里采用异或的位运算
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[j] ^ arr[i];
                    arr[i] = arr[i] ^ arr[j];
                }
            }
        }


    }


}
