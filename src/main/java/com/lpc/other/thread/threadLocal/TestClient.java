package com.lpc.other.thread.threadLocal;

/**
 * Created by liupengcheng1 on 2017/1/9.
 */
public class TestClient extends Thread {

    private SequenceNumber sequenceNumber;

    public TestClient(SequenceNumber sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread[" + Thread.currentThread().getName() + "]" + "[seqNum: ]" + sequenceNumber.getNextNum());
        }
    }

}
