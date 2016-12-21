package com.lpc.thread.one;

/**
 * Created by liupengcheng1 on 2016/12/20.
 */
public class Test {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            myThread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            System.out.println("e is ============= " + e);
        }
    }

}
