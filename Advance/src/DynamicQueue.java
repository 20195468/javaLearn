import java.util.ArrayList;
import java.util.List;

/**
 * @program: OJhomework
 * @description
 * @author: YourName
 * @create: 2020-07-06 08:26
 **/
public class DynamicQueue {
}

class MyOwnQueue {
    private List<Integer> integerList;
    private int start;
    private int end;

    public MyOwnQueue() {
        integerList = new ArrayList<>();
        start = 0;
        end = 0;
    }

    public void push(int data){
        integerList.add(data);
        end++;
    }
}
