import java.util.Arrays;

/**
 * java数组
 * @author 李星泽
 * @date 2020-06-29
 */
public class Demo_Arr {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 7};//静态初始化
        int[] arrs = new int[5];//动态初始化
//        System.out.println(arr.length);
//        //数组常见问题
//        //1.NullPointerException空指针异常
//        //没有指向任何对象但却调用了对象的方法
//        int[] b = null;
//        System.out.println(b.length);
//        //2.下标越界异常，很简单不再举例
//        //用foreach循环访问数组
//        Arrays.sort(arr);//对数组进行从小到大排序
//        for (int i:arr){
//            System.out.print(i+" ");
//        }
//        //二维数组的声明
//        int[][] twoarr = {{1, 2}, {2, 3}};//静态初始化
//        int[][] twoarrs = new int[3][4];
//        //用嵌套循环对数组进行赋值
//        for (int i = 0; i < twoarr.length; i++) {//行
//            for (int j = 0; j < twoarr[i].length; j++) {//列
//                System.out.print(twoarr[i][j] + " ");
//            }
//            System.out.println();
//        }
        //数组复制
        System.arraycopy(arr,0,arrs,0,4);
        for (int i:arrs){
            System.out.print(i+" ");
        }
    }
}
