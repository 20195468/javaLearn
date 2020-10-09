import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: OJhomework
 * @description Comparable的学习
 * @author: 李星泽
 * @create: 2020-10-09 19:57
 **/

/**
 * Comparable 用于进行比较（根据类中的某一部分元素）
 */
public class Comparable_Demo {
    public static void main(String[] args) {
        //这里之所以能对Integer进行比较是因为Integet实现了comparable这一接口
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(15);
        arr.add(10);
        arr.add(20);
        Collections.sort(arr);
        System.out.println(arr);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("lihua", 15));
        studentArrayList.add(new Student("xiaoming", 10));
        studentArrayList.add(new Student("zhanghua", 20));
        Collections.sort(studentArrayList);
        System.out.println(studentArrayList);

    }
}

//实现comparable使Student能被排序
class Student implements Comparable {
    private String name;
    private int ranking;

    public Student(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.ranking;
    }

    //根据ranking的值进行排序(this-o表示降序)
    @Override
    public int compareTo(Object o) {
        Student a = (Student) o;
        return this.ranking - a.ranking;
    }
}
