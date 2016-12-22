package com.lpc.other.thread.two;

/**
 * Created by liupengcheng1 on 2016/12/21.
 */
public class MyThread extends Thread {

    private int count = 10;

    synchronized public void run() {
        try {
            while (count > 0) {
                count--;
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("Thread is：" + Thread.currentThread().getName() + " count：" + count);
            }
        } catch (Exception e) {
            System.out.println("e is ============= " + e);
        }
    }

}
