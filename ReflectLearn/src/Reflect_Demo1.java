import javax.sound.midi.Soundbank;
import java.net.SocketTimeoutException;

/**
 * @program: OJhomework
 * @description 反射Class的获取
 * @author: 李星泽
 * @create: 2020-09-04 10:22
 **/
public class Reflect_Demo1 {
    /*
    获取对象的方式有三种
    1：Class.forName("全类名")
    2：类名.class :通过类名的属性class来获取
    3：对象.getClass():方法在object定义
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过第一种方法来获取(代码只有字节码文件并未进入内存)
        Class cls1 = Class.forName("Person");
        System.out.println(cls1);
        // 第二种方式获取(字节码文件已经加载进内存)
        Class cls2 = Person.class;
        System.out.println(cls2);
        // 第三种方式获取(已经存在该对象)
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        // 比较三种方式获得类是否相同
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        //同一个字节码文件在一次程序运行中只会被加载一次
    }
}
