package com.lpc.other.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConTest2 {
    private int size = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size);
    private Lock lock = new ReentrantLock();
    private Condition _empty = lock.newCondition();
    private Condition _full = lock.newCondition();

    public static void main(String[] args) {
        ConTest2 test2 = new ConTest2();
        Producer producer = test2.new Producer();
        Consumer consumer = test2.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        public void run() {
            consumer();
        }

        private void consumer() {
            try {
                lock.lock();
                while (queue.size() > 0) {
                    queue.poll();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                }
                _empty.await();
                _full.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class Producer extends Thread {
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                while (queue.size() < 10) {
                    queue.offer(1);
                    System.out.println("向队列取中插入一个元素，队列大小为：" + queue.size());
                }
                _empty.signal();
                _full.await();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
