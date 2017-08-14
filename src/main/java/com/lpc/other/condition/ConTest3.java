package com.lpc.other.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConTest3 {
    private int size = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size);
    private Lock lock = new ReentrantLock();
    private Condition _empty = lock.newCondition();
    private Condition _full = lock.newCondition();

    public static void main(String[] args) throws Exception {
        ConTest3 test3 = new ConTest3();
        Producer producer = test3.new Producer();
        Consumer consumer = test3.new Consumer();
        producer.start();
        consumer.start();

        Thread.sleep(10);
        producer.interrupt();
        consumer.interrupt();
    }

    class Consumer extends Thread {
        public void run() {
            consumer();
        }

        volatile boolean flag = true;

        private void consumer() {
            while (flag) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列为空，等待数据。。。");
                            _empty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }
                    queue.poll();
                    _full.signal();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread {
        public void run() {
            produce();
        }

        volatile boolean flag = true;

        private void produce() {
            while (flag) {
                lock.lock();
                try {
                    while (queue.size() == size) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            _full.await();
                        } catch (InterruptedException e) {
                            flag = false;
                        }
                    }
                    queue.offer(1);
                    _empty.signal();
                    System.out.println("向队列取中插入一个元素，队列大小为：" + queue.size());
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
