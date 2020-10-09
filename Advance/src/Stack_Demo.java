import java.util.EmptyStackException;

/**
 * @program: OJhomework
 * @description 设计一个栈结构，保持栈后进先出的原则
 * @author: 李星泽
 * @create: 2020-07-05 08:32
 **/
public class Stack_Demo {
    public static void main(String[] args) {
        Istack istack=new IntStack(3);
        istack.push(1);
        istack.push(2);
        istack.push(3);
        System.out.println(istack.poll());
        System.out.println(istack.peek());
    }
}

interface Istack {
    void push(int data);//放进栈堆

    int poll();//出栈

    int peek();//偷看一眼

    boolean empty();//强制清空
}

class IntStack implements Istack {
    private int pointer;//头指针
    private int[] arrs;//存储数据的数组

    public IntStack(int inisize) {
        if (inisize <= 0) {
            throw new IllegalArgumentException("Size必须大于0");
        }
        arrs = new int[inisize];
    }

    @Override
    public void push(int data) {
        if (pointer == arrs.length) {
            throw new ArrayIndexOutOfBoundsException("栈已满");
        }
        arrs[pointer] = data;
        pointer++;
    }

    @Override
    public int poll() {
        if (pointer <= 0) {
            throw new EmptyStackException();
        } else {
            int result = arrs[pointer - 1];
            pointer--;
            return result;
        }
    }

    @Override
    public int peek() {
        if (pointer <= 0) {
            throw new EmptyStackException();
        } else {
            return arrs[pointer - 1];
        }
    }

    @Override
    public boolean empty() {
        pointer = 0;
        return pointer == 0;
    }
}
