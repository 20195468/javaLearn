import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @program: OJhomework
 * @description
 * @author: YourName
 * @create: 2020-07-06 08:01
 **/
public class DynamicStack {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.peek());
    }
}

class MyStack {
    private List<Integer> integerList;
    private int pointer;

    public MyStack() {
        integerList = new ArrayList<Integer>();
    }

    public void push(int data) {
        integerList.add(data);
        pointer++;
    }

    public int poll() {
        if (pointer <= 0) {
            throw new EmptyStackException();
        }
        int aim = integerList.get(pointer - 1);
        pointer--;
        return aim;
    }

    public int peek() {
        if (pointer <= 0) {
            throw new EmptyStackException();
        }
        return integerList.get(pointer - 1);
    }
}
