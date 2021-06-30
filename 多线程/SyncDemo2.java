package demo1;

import java.util.Scanner;

/**
 *
 */
class MyThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("子线程1");
        synchronized (SyncDemo2.o) {
            System.out.println("子线程2");
        }
        System.out.println("子线程3");
    }
}

public class SyncDemo2 {
    public static Object o = new Object();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyThread1 t = new MyThread1();
        t.start();
        synchronized (o) {
            System.out.println("等待输入");
            sc.nextLine();
            System.out.println("主线程结束");
        }

    }
}
