import java.util.*;

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

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("laozhang", 39));
        teachers.add(new Teacher("laoli", 36));
        teachers.add(new Teacher("laozhou", 41));
        teachers.sort(Comparator.comparing(Teacher::getName));
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        Teacher teacher1=new Teacher("张雪",37);
        Teacher teacher2=new Teacher("张斌",59);
        Teacher teacher3=new Teacher("张斌",59);
        System.out.println(teacher1.equals(teacher2));
        System.out.println(teacher2.equals(teacher3));
    }
}

//实现comparable使Student能被排序
class Student implements Comparable<Student> {
    private String name;
    private int ranking;

    public Student(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.ranking;
    }

    //根据ranking的值进行排序(this-o表示降序)
    @Override
    public int compareTo(Student o) {
        return this.ranking - o.ranking;
    }
}

class Teacher {
    private String name;
    private int ranking;

    public Teacher(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object o) {
        //先比较地址
        if (this == o) return true;
        //再判断是否为同一个类
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return ranking == teacher.ranking && Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ranking);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
