package com.lpc.other.thread.five;

/**
 * Created by liupengcheng1 on 2017/1/13.
 */
public class BackupB extends Thread {

    private DBTools dbTools;

    public BackupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    public void run() {
        dbTools.backupB();
    }

}
