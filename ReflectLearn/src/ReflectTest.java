import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @program: OJhomework
 * @description 反射测试
 * @author: 李星泽
 * @create: 2020-09-06 19:02
 **/
public class ReflectTest {
    /*
    不能改变该类的任何代码，但可以创建任意类的对象，执行任意类的方法
     */
    public static void main(String[] args) throws Exception {
        //1、加载配置文件
        //1.1、创建properties对象
        Properties pro=new Properties();
        //1.2、加载配置文件转换为一个集合
        //1.2.1、获取class目录下的配置文件
        ClassLoader classLoader=ReflectTest.class.getClassLoader();
        InputStream is=classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //2、获取配置文件中定义的数据
        String className=pro.getProperty("className");
        String methodName=pro.getProperty("methodName");

        //加载该类进内存
        Class person=Class.forName(className);
        Object object=person.newInstance();
        Method method=person.getDeclaredMethod(methodName,String.class);
        method.invoke(object,"鱼肉");

    }
}
