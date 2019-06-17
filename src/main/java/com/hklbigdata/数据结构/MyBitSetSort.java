package com.hklbigdata.数据结构;

import org.apache.commons.lang3.RandomUtils;

import java.util.BitSet;

/**
 * Created by Kerven on 2019/6/17.
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
 * 使用bitset给1000万数据排序
 * 我们只需要把bitset里的数据在取出来就好了，其实就是已经实现了一个排序了，因为我们放入到bitset的时候
 * 指定的位置就是排好序的。
 */
public class MyBitSetSort {

    public static void main(String[] args) {

//        sortNums(generateNumber(10000000));

        final int size=10;
        int A[]={23,44,1,2,34,56,11,7,9,25};
        bitSort(A);
        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }


    }


    public static void bitSort(int[]A)
    {
        int size=A.length;
        final int number_range=60;//这个数的大小必须大于数组A中元素的最大值，否则数组A中的后面部分元素不会改变，关键点在下面循环内代码  A[j++]=i 处
        BitSet bits=new BitSet(number_range);
        for(int i=0;i<size;i++)
        {
            bits.set(A[i]);
        }
        for(int i=0,j=0;i<number_range;i++)
        {
            if(bits.get(i))
            {
                A[j++]=i;
            }
        }
        System.out.println("bits的内存："+bits.size());//bits增长内存的方式：64,128,192，256,320.。。  即64bits=8bytes的倍数
        //解释：操作系统分配内存时以字节为单位，也就是说分配的内存必须是byte的整数倍，按照这个思路，似乎只需要7byte =56bit就够了，那为什么又是8byte呢?
        //这又是因为标准库在实现bitset时以一个字为基本单位分配内存的(不是字节)，也就是说分配的内存大小必定是4byte的整数倍。这里我们虽然浪费了十几个bit的空间，
        //但是比起之前用int类型的数组或者char类型的数组来作为标记，这个程序节约了很多内存的(50个int数据消耗内存200byte，而50个char数据消耗内存50byte)。
    }
/*---------------------
    作者：智造官
    来源：CSDN
    原文：https://blog.csdn.net/qq_28511781/article/details/70948703
    版权声明：本文为博主原创文章，转载请附上博文链接！*/


    // 初始化一千万整数
    private static int[] generateNumber(int size){
        long start = System.currentTimeMillis();
        System.out.println("开始生成数据");
        int[] nums = new int[size];
        for(int i=0;i<size;i++){
            nums[i] = RandomUtils.nextInt(0, size);
        }
        System.out.println("生成数据完成,耗时:"+(System.currentTimeMillis()-start)+"毫秒");
        return nums;
    }

    // 使用BitSet进行排序
    private static String sortNums(int[] nums) {
        long start = System.currentTimeMillis();
        System.out.println("开始排序");
        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        BitSet bitSet = new BitSet(len);
        bitSet.set(0, len, false);
        for (int i = 0; i < len; i++) {
            bitSet.set(nums[i], true);
        }
        for (int i = 0; i < len; i++) {
            if (bitSet.get(i)) {
                sb.append(i).append(",");
            }
        }
        System.out.println("排序完成,耗时:" + (System.currentTimeMillis() - start) + "毫秒");
        return sb.toString();


    }

}
