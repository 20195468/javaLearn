import java.io.*;
import java.util.Scanner;

/**
 * @program: OJhomework
 * @description 从pdf复制的文字格式调整，存入文件中
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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("charChange.txt"));
        bufferedWriter.write(aimStr);
        bufferedWriter.close();
    }
}
