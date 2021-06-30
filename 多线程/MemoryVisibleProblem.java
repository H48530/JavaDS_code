package demo1;

import java.util.Scanner;

class MyThread extends Thread {
    @Override
    public void run() {

        while (MemoryVisibleProblem.flag) {
        }
        System.out.println("子线程退出了");
    }
}

public class MemoryVisibleProblem {
    public static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();

        Scanner sc = new Scanner(System.in);
        System.out.println("输入：");
        sc.nextLine();
        flag = false;
        System.out.println("要求子线程退出");

        t.join();
        System.out.println("子线程退出了");
    }
}
