import java.sql.Statement;
import java.util.Random;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-03-20 19:42
 **/
public class HomeWork20210320 {
    //交换函数
    public static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    //划分
    public static int partition(int[] arr, int left, int right) {
        int x = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        System.out.println("");
        for (int number : arr) {
            System.out.print(number+" ");
        }
        System.out.println();
        return i + 1;
    }
    //随机选取交换
    public static int randomSelect(int[] arr, int left, int right) {
        Random random = new Random();
        int i = random.nextInt(right - left + 1) + left;
        swap(arr, i, right);
        return partition(arr, left, right);
    }
    //查询前K小个数组
    public static int searchKLowArr(int[] arr, int left, int right, int k) {
        if (left == right) return left;
        int sortNumber = randomSelect(arr, left, right);
        int numberOfSorted = sortNumber - left + 1;
        if (k == numberOfSorted) return numberOfSorted;
        else if (k < numberOfSorted) return searchKLowArr(arr, left, sortNumber - 1, k);
        else return searchKLowArr(arr, sortNumber + 1, right, k - numberOfSorted);
    }
    //得到目标函数
    public static int[] aimArr(int[] arr,int left,int right,int k){
        int splitNumber=searchKLowArr(arr,0,arr.length-1,4);
        int [] aimArr=new int[k];
        for (int i=0;i<k;i++){
            aimArr[i]=arr[i];
        }
        return aimArr;
    }

    public static void main(String[] args) {
        int[] arr = {6,10,13,3,5,8,3,2,11};
        int[] aimArr=aimArr(arr,0,arr.length-1,4);
        System.out.println("main");
        for (int i : aimArr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
