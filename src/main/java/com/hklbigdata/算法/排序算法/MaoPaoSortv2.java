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



    //   冒泡也是两层循环，它的对比是进行把两个相邻的做两两比对，大的往后仍,每次循环完毕都是得到了一个最大的放在了末尾处。
//     外层的循环每完成一次也就少了一个要对比的数，所以内存循环也就少了一次，所以有 -i 的操作
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
