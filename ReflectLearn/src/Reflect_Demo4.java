import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: OJhomework
 * @description 反射中方法的获取和对方法的操作
 * @author: 李星泽
 * @create: 2020-09-06 10:18
 **/
public class Reflect_Demo4 {
    /*
    反射中方法的获取共有四种(和成员变量、构造函数和获取相同)
     */
    public static void main(String[] args) throws Exception {
        //获取所有类型的方法
        Class personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
            String methodName = method.getName();
            System.out.println(methodName);
        }
        Method eat_Method1 = personClass.getMethod("eat");
        Person person = new Person();
        eat_Method1.invoke(person);
        Method eat_Method2 = personClass.getMethod("eat", String.class);
        eat_Method2.invoke(person, "猪油炒饭");
        Method method_showMessage = personClass.getDeclaredMethod("showMessage", String.class);
        method_showMessage.setAccessible(true);
        Field b = personClass.getDeclaredField("b");
        b.set(person, "拼命奔跑");
        method_showMessage.invoke(person,"没伞的孩子要学会");
        //类名的获取
        System.out.println(personClass.getName());

    }
}
