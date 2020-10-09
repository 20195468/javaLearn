import java.math.BigDecimal;

/**
 * java 进阶学习
 *
 * @author 李星泽
 * @date 2020-06-29
 */
public class DataType {
    public static void main(String[] args) {
        //处理小数精度问题，避免因计算机计算问题产生误差
        //注意括号里面一定是"数字"，而不是单独是数字；
        BigDecimal big1 = new BigDecimal("0.09");
        BigDecimal big2 = new BigDecimal("0.01");
        System.out.println("result:" + " " + big1.add(big2));

        //基本数据类型，char
        char e = 'A';
        System.out.println("e=" + e);
        e++;
        System.out.println("e=" + e);
        //转义字符的使用
        System.out.println("你好\"中国\"");
        //字符的转换
        char f = 65;
        System.out.println("f=" + f);

        //基本数据类型布尔值
        boolean bl = 1 > 2;
        System.out.println("bl=" + bl);

        //强制类型转换，小字节向大字节自动转换，大字节不能向小字节转换换
    }
}
