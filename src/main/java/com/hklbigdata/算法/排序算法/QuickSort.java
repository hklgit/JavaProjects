package com.hklbigdata.算法.排序算法;

import java.util.Arrays;

/**
 * Created by Kerven-HAN on 2019/10/17 18:18.
 * Talk is cheap , show me the code
 */



//利用了二分的思想
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,41212,-12,232,212,67,12323,-10101,22,572,999};
//        int[] arr = {41,-12,23,122,12,90,20};
//        int[] arr = {41,-12};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static  void  quickSort(int[] arr,int left,int right){

//        定义几个变量

        int i,j,base,temp;

        if( left > right){

            return;
        }

        i = left;
        j = right;
        base = arr[left];

        while (i < j){
            while ( base <= arr[j] && i < j){
                j--;
            }

            while ( base >= arr[i] && i<j){
                i++;
            }

            if( i < j){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
//        交换基准值和i=j的位置的值
//        int p = arr[i];
//        arr[i] = arr[left];
//        arr[left] = p;

//        这个时候是i=j 所以上面和下面都是一样的
//        因为left是基准
        int p = arr[j];
        arr[j] = arr[left];
        arr[left] = p;

        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);

        //        这个时候是i=j 所以上面和下面都是一样的
//        quickSort(arr,left,j-1);
//        quickSort(arr,j+1,right);









    }
}
