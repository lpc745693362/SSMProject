package com.lpc.other.thread.two;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class Test {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "A");
        Thread thread2 = new Thread(myThread, "B");
        Thread thread3 = new Thread(myThread, "C");
        Thread thread4 = new Thread(myThread, "D");
        Thread thread5 = new Thread(myThread, "E");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
