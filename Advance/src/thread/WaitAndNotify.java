package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-21 16:25
 **/
public class WaitAndNotify {
    public static void main(String[] args) {
        Object object=new Object();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        new Thread(() -> {
            while (true){
                synchronized (object){
                    System.out.println("我要什么包子");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("开始吃包子当前时间为："+df.format(new Date()));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("已经吃好包子,快乐！当前时间为："+df.format(new Date())+"\n----------");
            }
        }).start();

        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object){
                    System.out.println("开始做包子 当前时间为："+df.format(new Date()));
                    object.notify();
                }
            }

        }).start();
    }
}
