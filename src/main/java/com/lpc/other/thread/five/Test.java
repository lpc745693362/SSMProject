package com.lpc.other.thread.five;

/**
 * 创建20个线程，其中10个是将数据备份到A数据库中，另外10个线程将数据备份到B数据库中，并且备份A数据库和B数据库交叉进行
 */
public class Test {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }

}
