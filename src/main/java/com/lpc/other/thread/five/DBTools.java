package com.lpc.other.thread.five;

/**
 * Created by liupengcheng1 on 2017/1/13.
 */
public class DBTools {

    private volatile boolean prevIsA = false;

    synchronized public void backupA() {
        try {
            while (prevIsA == true){
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("（●─●）（●─●）（●─●）（●─●）（●─●）");
            }
            prevIsA = true;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB() {
        try {
            while (prevIsA == false){
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("(⊙ω⊙)(⊙ω⊙)(⊙ω⊙)(⊙ω⊙)(⊙ω⊙)");
            }
            prevIsA = false;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
