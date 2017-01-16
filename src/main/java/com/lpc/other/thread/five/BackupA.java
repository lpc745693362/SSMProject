package com.lpc.other.thread.five;

/**
 * Created by liupengcheng1 on 2017/1/13.
 */
public class BackupA extends Thread {

    private DBTools dbTools;

    public BackupA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    public void run() {
        dbTools.backupA();
    }

}
