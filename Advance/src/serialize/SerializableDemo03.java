package serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-19 21:28
 **/
public class SerializableDemo03 {
    public static void main(String[] args) throws Exception {
        File file = new File("Advance/src/serialize/demo.txt");
        Person p = new Person("李四", 19);
        set(file, p);
        List<Person> list = get(file);
        for (Person per : list) {
            System.out.println(per);
        }
    }

    public static void set(File file, Person p) throws Exception {
        FileOutputStream fos = new FileOutputStream("file", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.close();
    }

    public static List<Person> get(File file) throws Exception {
        List<Person> list = new ArrayList<Person>();
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = null;
        while (fis.available() > 0) {
            //每次都new一个新的ObjectInputStream
            ois = new ObjectInputStream(fis);
            Person p = (Person) ois.readObject();
            list.add(p);
        }
        ois.close();
        return list;
    }
}

class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
