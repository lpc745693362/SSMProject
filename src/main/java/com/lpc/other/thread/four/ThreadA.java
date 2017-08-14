package com.lpc.other.thread.four;

/**
 * Created by liupengcheng1 on 2017/1/4.
 */
public class ThreadA implements Runnable {

    private MyList myList;
    private Object lock;

    public ThreadA(MyList myList, Object lock) {
        this.myList = myList;
        this.lock = lock;
    }

    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    myList.add();
                    if(myList.size() == 5){
                        lock.notify(); // notify执行后并不立即释放锁
                        System.out.println("已发出通知！");
                    }
                    System.out.println("已经增加了 " + (i + 1) + " 个元素！");
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
