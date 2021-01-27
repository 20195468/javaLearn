package serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-19 19:36
 **/
public class SerializeDemo {
    public static void main(String[] args) throws Exception {
//        //非追加模式进行序列化
//        Employee employee0 = new Employee("小李");
//        Employee employee1 = new Employee("小刘");
//        Employee employee2 = new Employee("小刘");
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Advance/src/serialize/employeeSer.txt"));
//            objectOutputStream.writeObject(employee0);
//            objectOutputStream.writeObject(employee1);
//            objectOutputStream.writeObject(employee2);
//            objectOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//
//            //非追加模式进行反序列化读取
//            FileInputStream fis = new FileInputStream("Advance/src/serialize/employeeSer.txt");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
//            List<Employee> employees = new ArrayList<>();
//            //fis.available()>0表示扔有字节可以读出
//            while (fis.available() > 0) {
//                employees.add((Employee) objectInputStream.readObject());
//            }
//            objectInputStream.close();
//            fis.close();
//            System.out.println(employees);
//
//        } catch (ClassNotFoundException c) {
//            System.out.println("未发现类");
//            c.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

////        Employee employee0 = new Employee("小李");
//        Employee employee1 = new Employee("小刘");
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Advance/src/serialize/addEmployeeSer.txt",true));
////            objectOutputStream.writeObject(employee0);
//            objectOutputStream.writeObject(employee1);
//            objectOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            FileInputStream fis = new FileInputStream("Advance/src/serialize/addEmployeeSer.txt");
            ObjectInputStream objectInputStream = null;
            List<Employee> employees = new ArrayList<>();
            //避免每次追加时将头读进去
            while (fis.available()>0){
                objectInputStream=new ObjectInputStream(fis);
                employees.add((Employee) objectInputStream.readObject());
            }
            System.out.println(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

class Employee implements Serializable {
    private String name;
    private long code;
    Random random = new Random();

    public Employee(String name) {
        this.name = name;
        this.code = Math.abs(random.nextLong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
