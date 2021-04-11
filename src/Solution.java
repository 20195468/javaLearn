import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想计算多少枚硬币:");
        int money = scanner.nextInt();
        int[] temp = new int[money + 1];  //存放每种硬币取的最少的取法
        int[] value = {1, 4, 7}; //四种硬币

        //动态规划的核心,用for循环去填充每次能标记上的
        for (int i = 1; i < temp.length; i++) { //取的硬币的数量
            int minCountTemp = i; //初始化取该硬币最小的个数，不可能大于对应面值（全取面值为1的）
            for (int j = 0; j < value.length; j++) {
                if (i >= value[j]) { //取的硬币的面值比有的面值要大。
                    int minCount = temp[i - value[j]] + 1; //1表示取该面值的一个，temp[i - value[j]]表示取减去该面值后最小的取值个数
                    if (minCount < minCountTemp) {
                        minCountTemp = minCount;  //保存了这一趟比较的最小的取的硬币值
                    }
                }
            }
            temp[i] = minCountTemp;
        }
        System.out.println("至少需要" + temp[money] + "枚硬币");
    }


}
