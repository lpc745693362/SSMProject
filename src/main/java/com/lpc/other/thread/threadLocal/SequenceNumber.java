package com.lpc.other.thread.threadLocal;

/**
 * ThreadLocal线程安全
 */
public class SequenceNumber {

    private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        // 通过匿名内部类覆盖ThreadLocal的initialValue方法，指定初始值
        public Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sequenceNumber = new SequenceNumber();
        TestClient testClient1 = new TestClient(sequenceNumber);
        TestClient testClient2 = new TestClient(sequenceNumber);
        TestClient testClient3 = new TestClient(sequenceNumber);
        testClient1.start();
        testClient2.start();
        testClient3.start();
    }

}
