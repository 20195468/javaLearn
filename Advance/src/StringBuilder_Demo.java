/**
 * @program: OJhomework
 * @description 动态字符串的使用
 * @author: 李星泽
 * @create: 2020-07-05 09:05
 **/
public class StringBuilder_Demo {
    public static void main(String[] args) {
        //StringBuffer有同步机制适用于多线程而
        // StringBuilder适用于单线程，线程更加安全
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        stringBuilder.append(" World");
        System.out.println(stringBuilder);
        System.out.println("字符串长度：" + stringBuilder.length());
        stringBuilder.insert(5, " this");
        System.out.println(stringBuilder);
        stringBuilder.replace(5, 11, " another ");
        System.out.println(stringBuilder);
        stringBuilder.delete(6, 14);
        System.out.println(stringBuilder);
        stringBuilder.setCharAt(1, 'a');
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}
