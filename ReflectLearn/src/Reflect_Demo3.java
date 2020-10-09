import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @program: OJhomework
 * @description 反射中构造函数的获取和对构造函数的操作
 * @author: 李星泽
 * @create: 2020-09-06 09:31
 **/
public class Reflect_Demo3 {
    public static void main(String[] args) throws Exception {
        /*
        反射中构造函数的获取同样有四种方法
        1、Constructor[] getConstructors() 只会获取所有public修饰的构造方法
        2、Constructor getConstructor(参数类型.class) 只会获取单个的public修饰的构造方法(根据参数类型进行区分)
        操作部分
        创建对象newInstance(args)
         */
        Class personClass = Person.class;
        //第一种方法，只会获取所有public修饰的构造方法
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        //第二种方法，只会获取单个的public修饰的构造方法(根据参数类型进行区分)
        Constructor personHave = personClass.getConstructor(String.class, int.class);
        System.out.println(personHave);
        System.out.println("----------------");
        //第三种方法，可以获取所有类型修饰的构造函数
        Constructor[] constructors1 = personClass.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor);
        }
        //第四种方法，获取单个的任何修饰符修饰的构造函数(根据形参类型进行区分)
        Constructor constructor = personClass.getDeclaredConstructor();
        System.out.println(constructor);
        System.out.println("-------创建对象-------");
        //创建带参形式的对象(及时创建参数形式一样，两个对象的地址值也不相同)
        Object object = personHave.newInstance("张三", 24);
        System.out.println(object);
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(object));
        //也可以创建不带参形式的对象(这种方式比较麻烦)
        Object object1 = personHave.newInstance("张三", 24);
        System.out.println(object1);
        //创建不带参形式的对象可以通过class直接创建
        Object object2 = personClass.newInstance();
        Field age=personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(object2,13);
        System.out.println(object);

        //反射获取的构造函数同样存在暴利反射的能力
        //setAccessible(true);
    }
}
