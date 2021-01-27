package thread;

import java.io.ObjectInputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-21 09:04
 **/
public class Thread_Demo {

    public static void main(String[] args) {

//        Pig pig = new Pig("HengHeng");
//        //改变线程名称
//        pig.setName("猪宝一号");
//        pig.start();
//        System.out.println("获取主线程名称:" + Thread.currentThread().getName());
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println(Thread.currentThread().getName() + "-->" + i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        RunnableImpl runnableImpl = new RunnableImpl();
        Thread thread1 = new Thread(runnableImpl);
        Thread thread2 = new Thread(runnableImpl);
        Thread thread3 = new Thread(runnableImpl);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Pig extends Thread {
    private String voice;

    public Pig(String voice) {
        //改变线程名称
        super("pig");
        this.voice = voice;
    }

    @Override
    public void run() {
        //当前线程名称
        Thread t = currentThread();
        System.out.println(t);
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableImpl implements Runnable {
    private static int ticket = 100;
    final Object object = new Object();
    Lock l=new ReentrantLock();

    @Override
    public void run() {
        synchronized (object) {
            //创建锁保证线程安全
            l.lock();
            while (ticket > 0) {
                try {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + "卖出第 " + ticket-- + "票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                //锁对象是this
//                ticketSell();
//                //所对象是Class
//                ticketSellStatic();
            }
            l.unlock();
        }
    }

    public synchronized void ticketSell() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "卖出第 " + ticket-- + "票");
    }

    public static synchronized void ticketSellStatic() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "卖出第 " + ticket-- + "票");
    }
}