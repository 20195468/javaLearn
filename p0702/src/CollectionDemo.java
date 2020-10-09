import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: OJhomework
 * @description java的集合类讲解 List Vector
 * @author: YourName
 * @create: 2020-07-02 08:52
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        String week = "";
        //不使用泛型的情况
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove("2");
        System.out.println(list.get(1));

    }
}
