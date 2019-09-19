/**
 * Created by Kerven on 2019/7/3.
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
 */
public class HeapSortTest {


    /**
     *
     * @param arr 要调整的数组
     * @param cur 当前节点
     * @param length 节点的个数
     */
    public void shiftDown(int[] arr,int cur,int length){

        int leftChild = 2*cur + 1;
        int temp = 0;

        while(leftChild < length){
            //这一步的判断是为了下一步判断是用左孩子还是有孩子来作比较儿准备的
            if( leftChild + 1 < length && arr[cur] < arr[ leftChild +1 ]){
                leftChild ++ ;
            }
            if( arr[cur] > arr[leftChild]) break;

            temp = arr[cur];
            arr[cur] = arr[leftChild];
            arr[leftChild] = temp;

            cur = leftChild;
            leftChild = 2* leftChild + 1;

        }




    }


}
