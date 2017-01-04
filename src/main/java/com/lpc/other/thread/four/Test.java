package com.lpc.other.thread.four;

/**
 * wait/notify
 */
public class Test {

    public static void main(String[] args) {
        MyList myList = new MyList();
        Object lock = new Object();

        ThreadA threadA = new ThreadA(myList, lock);
        Thread a = new Thread(threadA);
        a.setName("A");
        a.start();

        ThreadB threadB = new ThreadB(myList, lock);
        Thread b = new Thread(threadB);
        b.setName("B");
        b.start();
    }

}
