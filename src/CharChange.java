import java.io.*;
import java.util.Scanner;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2020-10-03 10:21
 **/
public class CharChange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("charChange.txt"));
        String string = bufferedReader.readLine();
        String aimStr = string;
        while (string != null) {
            aimStr = aimStr + string;
            string = bufferedReader.readLine();
        }
        bufferedReader.close();
        aimStr = aimStr.replace(" , ", "，");
        aimStr = aimStr.replace(",", "，");
        aimStr = aimStr.replace(" :", "");
        aimStr = aimStr.replace(" 。", "。");
        aimStr = aimStr.replace(" ", "");
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("charChange.txt"));
        bufferedWriter.write(aimStr);
        bufferedWriter.close();
//        System.out.println();
//        System.out.println("输出为：");
//        System.out.println(aimStr);
    }
}
