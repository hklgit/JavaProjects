package com.hklbigdata.算法.排序算法;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Kerven-HAN on 2019/10/16 13:56.
 * Talk is cheap , show me the code
 */
public class MaoPaoSortv2 {


    public static void main(String[] args) {

         int[] arr = {1,23,45,12,66,25,134,90,99,34234324,1233};
         sort(arr);
        System.out.println(Arrays.toString(arr));

    }




    public static void sort(int[] arr){

        int len = arr.length - 1;

        boolean flag = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {  //每循环一次都少一个元素,就少了一次比对

                if( arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }

            }
            if (flag) {break;}
        }





    }

}
