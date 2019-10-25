/**
 * Created by Kerven-HAN on 2019/10/22 13:43.
 * Talk is cheap , show me the code
 */
public class 快速排序 {


    public static void quickSort(int[] arr, int left, int right) {
        int i, j, temp, base;

        i = left;
        j = right;
        base = arr[left];

        if (left > right) {
            return;
        }

        while( i < j ){
            while( base < arr[j] && i < j ){
                j--;
            };
            while( base > arr[i] && i < j ){
                i++;
            };

            if( i < j ){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp ;
            }
        }

        int p  = arr[i];
        arr[i]  = arr[left];
        arr[left] = p ;

        quickSort(arr,left,j-1);
        quickSort(arr,j+1,right);


    }


}
