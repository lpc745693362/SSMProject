package com.lpc.other.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConTest {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws Exception {
        ConTest conTest = new ConTest();
        Consumer consumer = conTest.new Consumer();
        Producer producer = conTest.new Producer();

        consumer.start();
        Thread.sleep(10);
        producer.start();
    }

    class Consumer extends Thread {
        public void run() {
            consumer();
        }

        private void consumer() {
            try {
                lock.lock();
                System.out.println("我在等待一个信号：" + currentThread().getName());
                condition.await();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("接收到一个信号：" + currentThread().getName());
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
                System.out.println("我拿到锁：" + currentThread().getName());
                condition.signal();
                System.out.println("我发出了一个信号：" + currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
