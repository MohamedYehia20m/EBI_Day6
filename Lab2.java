package EBI;

import java.sql.*;

public class Lab2 {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(thread1);

        MyThread thread3 = new MyThread();
        Thread thread4 = new Thread(thread3);

        NextThread thread5 = new NextThread();
        Thread thread6 = new Thread(thread5);

        NextThread thread7 = new NextThread();
        Thread thread8 = new Thread(thread7);

        thread2.start();
        thread4.start();
        thread6.start();
        thread8.start();
    }

    public static class MyThread implements Runnable {
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println("i am thread from MyThread class");
            }

        }

    }

    public static class NextThread implements Runnable {
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println("i am thread from NextThread class");
            }
        }
    }

}
