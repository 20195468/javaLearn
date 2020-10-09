/**
 * @program: OJhomework
 * @description
 * @author: YourName
 * @create: 2020-07-04 08:58
 **/
public class Queue_Demo {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue(3);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
    }
}

class MyQueue {
    private int[] arrs;
    private int start;
    private int end;
    private int size;

    MyQueue(int iniSize) {
        if (iniSize <= 0) {
            throw new IllegalArgumentException("Size必须大于0");
        }
        arrs = new int[iniSize];
        start = 0;
        end = 0;
        size = 0;
    }

    //进队
    public void push(int date){
        if(end==arrs.length){
            throw new ArrayIndexOutOfBoundsException("队列已满");
        }
        arrs[end]=date;
        end++;
        size++;
    }

    //出队
    public int poll(){
        if (size==0){
            throw new ArrayIndexOutOfBoundsException("队列空了");
        }
        int temp=start;
        start++;
        size--;
        return arrs[temp];
    }

    //偷看一样
    public int peek(){
        if (size==0){
            return -1;
        }
        return arrs[start];
    }
}
