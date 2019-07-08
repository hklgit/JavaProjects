package com.hklbigdata.数据结构;

/**
 * @Author: kerven hankunlun@coocaa.com
 * @Date: 2019/6/16 15:29
 * Talk is cheep , show me the code
 */
public class Heap {

    public static void main(String[] args) {

        int[] a  = {2,4,34,12,67,88,22,56};

        //构建&排序
        minHeap_Sort(a,a.length);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }




    }

    public static void minHeap_Sort(int a[], int n) {
            int temp = 0;
             makeMinHeap(a, n);
             //我们是从0开始编号，所以是
            for (int i = n - 1; i > 0; i--) {
                     temp = a[0];
                     a[0] = a[i];
                     a[i] = temp;
                    minHeapFixdown(a, 0, i);
            }
          }


    //构建最小堆
    public static void makeMinHeap(int a[], int n) {
        // i 从第一个非叶子节点开始调整
        for (int i = (n - 1) / 2; i >= 0; i--) {
            minHeapFixdown(a, i, n);
        }
    }

    /**
     * @param arr    要调整的数组
     * @param i      开始调整的位置
     * @param length 数组的长度
     */
    public static void minHeapFixdown(int[] arr, int cur, int length) {
        //左孩子结点，我们首先从第一个非叶子结点开始找，
        //所以说，他肯定是得有左孩子的，但是是否有右孩子是不确定的

        int leftChild = 2 * cur + 1;
        int temp = 0;

        //注意这里的循环条件。
        while ( leftChild < length ) {
            // 有右孩子结点，并且说，右孩子大于左孩子
            if (leftChild + 1 < length && arr[leftChild] < arr[leftChild+ 1]) {
                leftChild++;  // 这里就是对进行了重新的赋值，做了一个+1的操作，其实就是从左孩子变为了右孩子
            }

            if (arr[cur] >= arr[leftChild]) {
                break;
            }

            temp = arr[cur];
            arr[cur] = arr[leftChild];
            arr[leftChild] = temp;

            cur = leftChild;

            leftChild = 2*cur + 1;





        }


    }
}
