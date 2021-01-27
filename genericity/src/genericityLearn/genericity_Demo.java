package genericityLearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-19 09:24
 **/
public class genericity_Demo {
    public static void main(String[] args) {
        Student<Integer> student = new Student<>("小明", 15);
        System.out.println(student);
        Student<University> student1 = new Student<>("小明", new University("沈阳"));
        System.out.println(student1);
        List<Student<Integer>> studentList = new ArrayList<>();
        studentList.add(student);
        System.out.println(studentList);
    }
}

class Student<E> {
    private String name;
    private E type;

    public Student(String name, E type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public E getType() {
        return type;
    }

    public void setType(E type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}

class University {
    String address;

    public University(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "University{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
