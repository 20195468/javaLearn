import java.lang.reflect.Field;

/**
 * @program: OJhomework
 * @description 反射中成员变量的获取和对成员变量的赋值
 * @author: 李星泽
 * @create: 2020-09-05 15:59
 **/
public class Reflect_Demo2 {
    /*
    反射获取成员变量有四种方法
    1、Field[] getFields() 获取所有的public的成员变量
    2、Field getField("名称") 获取单个的public的成员变量
    3、Field[] getDeclaredFields() 获取所有类型的成员变量
    4、Field getDeclaredField("名称")获取任何类型的单个成员变量
    赋值部分
    get(对象)获取相应成员变量的值
    set(对象,赋值部分)对相应的成员变量进行赋值
    暴利赋值法setAccessible(true)
     */
    public static void main(String[] args) throws Exception {
        //获取所有的public成员变量
        Class personClass = Person.class;
        System.out.println("通过反射获取类对象" + personClass);
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取单个的public的成员变量  如果不是public则会报错
        Field field = personClass.getField("a");
        System.out.println(field);
        //获取所有类型的成员变量
        fields = personClass.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        //获取任何类型的单个成员变量
        Field b = personClass.getDeclaredField("b");
        System.out.println(b);

        Person person1 = new Person();
        Person person2 = new Person();
        //获取对象中的值
        Object value1 = b.get(person1);
        System.out.println(value1);
        //对类中的成员变量赋值
        b.set(person1, "张三");
        System.out.println(person1);
        //以上情况是对非私有的成员变量进行赋值，如果为private的成员变量
        //则需要进行暴力赋值setAccessible(true)
        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true);
        d.set(person1, "李四");
        System.out.println(person1);
    }
}
