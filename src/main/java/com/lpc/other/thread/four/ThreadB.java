package com.lpc.other.thread.four;

/**
 * Created by liupengcheng1 on 2017/1/4.
 */
public class ThreadB implements Runnable {

    private MyList myList;
    private Object lock;

    public ThreadB(MyList myList, Object lock) {
        this.myList = myList;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (myList.size() != 5) {
                    System.out.println("wait begin " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
