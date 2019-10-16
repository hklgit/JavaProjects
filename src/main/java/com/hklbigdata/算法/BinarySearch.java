package com.hklbigdata.算法;

/**
 * @Author: kerven
 * @Date: 2019/6/13 7:25
 * Talk is cheep , show me the code
 *
 * 二分查找
 * 这个思路在很多地方都有用到，很经典
 * 注意的点：
 * 数组首先是要有序的，然后我们还要注意一个点，就是求middle的时候要注意一个点
 *
 */
public class BinarySearch {

    public static void main(String[] args) {
        //1；准备一个有序的数组
        int[] arr = {2,6,12,16,18,20,99,101,102,105};
        int i = binarySearch(arr, 99);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr,int target){
        //1:做合法性校验
        //1.1确定首位元素
        int start = 0;
        int end = arr.length-1;
        int mid;
        //1.2 校验
//        if(target < start || target > end || start >end) return -1;


        //2: 这里有个循环的条件很关键
        while( start<=end){
//            这里有两个点：1：mid定义在外部，赋值在内部
//                    2：为了防止大数相加溢出，所以才用了 start+(end-start)/2
//
             mid = start + (end-start)/2;
            // 拿到中间值的角标
            if(arr[mid]>target){
                end = mid -1;
            }else if (arr[mid]<target){
                start = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
