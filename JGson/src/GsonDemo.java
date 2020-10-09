import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: OJhomework
 * @description
 * @author: YourName
 * @create: 2020-07-12 14:58
 **/
public class GsonDemo {

    //将对象转换成json字符串
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
//        //设置漂亮的格式
//        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
//        Gson gson1=new Gson();
        return gson.toJson(object);
    }


    //将字符串转换为对象
    public static Object toObj(String js, Class<?> c) {
        JsonParser parser = new JsonParser();
        //得到一个装有属性的Json数组
        JsonArray jsonArray = parser.parse(js).getAsJsonArray();
        Gson gson = new Gson();
        Object obj = null;
        //将属性放在obj中
        for (JsonElement jsonElement : jsonArray) {
            obj = gson.fromJson(jsonElement, c);
        }
        return obj;
    }

    //返回一个对象集合
    public static List<Object> toObjectList(String js, Class<?> c) {
        JsonParser parser = new JsonParser();
        //得到一个装有属性的Json数组，有几个对象就有几个数组
        JsonArray jsonArray = parser.parse(js).getAsJsonArray();
        Gson gson = new Gson();
        List<Object> objects = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            Object object = gson.fromJson(jsonElement, c);
            objects.add(object);
        }
        return objects;
    }

    //解析json map对象
    public static Map<String, Object> getMapJson(String jsonString) {
        Gson gson = new GsonBuilder().create();
        Map<String, Object> map = gson.fromJson(jsonString, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
//        JsonParser parser = new JsonParser();
//        JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
//        System.out.println(jsonObject);
//        return null;
    }


    public static void main(String[] args) {

//        String js = "[{\"age\":33,\"name\":\"张三\"}]";
//        Object object = toObj(js, Person.class);
//        Person person = (Person) object;
//        System.out.println(person.age + "  " + person.name);

//        String js = "[{\"age\":33,\"name\":\"张三\"},{\"age\":35,\"name\":\"李四\"}]";
        String js = "[{\"age\":33,\"name\":\"张三\",\"map\":{\"33\":\"张三\"},\"list\":[\"33 张三\"]},{\"age\":31,\"name\":\"李四\",\"map\":{\"31\":\"李四\"},\"list\":[\"31 李四\"]},{\"age\":28,\"name\":\"王五\",\"map\":{\"28\":\"王五\"},\"list\":[\"28 王五\"]}]";
        List<Object> objects = toObjectList(js, Person.class);
        for (Object object : objects) {
            Person person = (Person) object;
            System.out.println(person.age + "   " + person.name + "  " + person.map+"  "+person.list);
        }

//        String js="{\"Student\":{\"iD\":\"20195468\",\"name\":\"李四\"},\"Person\":{\"age\":33,\"name\":\"张三\"}}";
//        //返回的json的map型
//        Map<String,Object> map=getMapJson(js);
//        System.out.println(map);
//        System.out.println(map.get("Person"));

//        Person person = new Person(33, "张三");
//        Student student = new Student("20195468", "李四");
//        System.out.println(toJson(person));
//        System.out.println(toJson(student));
//        Person[] persons = new Person[3];
//        persons[0] = new Person(33, "张三");
//        persons[1] = new Person(31, "李四");
//        persons[2] = new Person(28, "王五");
//        System.out.println(toJson(persons));
//        Map map = new HashMap();
//        map.put("Person", person);
//        map.put("Student", student);
//        System.out.println(toJson(map));
    }
}

interface Human {

}

class Person implements Human {
    int age;
    String name;
    Map<String, String> map = new HashMap<String, String>();
    List<String> list = new ArrayList<String>();

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        map.put(age + "", name);
        list.add(age + " " + name);
    }
}

class Student implements Human {
    String iD;
    String name;

    public Student(String ID, String name) {
        this.iD = ID;
        this.name = name;
    }
}

