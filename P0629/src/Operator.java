import java.util.ArrayList;

/**
 * java运算符学习
 * @author 李星泽
 * @date 2020-02-29
 */
public class Operator {
    public static void main(String[] args) {
        int age = +10;//正号的使用
        System.out.println("age=" + age);//连接符的使用
        //先是数字相加后是连接符相加
        System.out.println(1 + 2 + 3 + "hello" + 4 + 5 + 6);

        //%运用  符号取决于被除数
        System.out.println("-10%3=" + (-10 % 3));
        System.out.println("10%-3=" + (10 % -3));
    }
}
