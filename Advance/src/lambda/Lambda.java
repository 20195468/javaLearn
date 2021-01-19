package lambda;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-17 17:54
 **/
public class Lambda {
    public static void main(String[] args) {
        System.out.println("lambda表达式学习");
        ReturnPara returnPara = age -> {
            System.out.println("我几年" + age + "岁");
            return age + 5;
        };
        System.out.println("返回值为："+returnPara.showMessage(3));
    }
}
