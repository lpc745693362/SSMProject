package com.lpc.other.io;

import java.io.File;

/**
 * 获取系统路径
 */
public class PathTest {

    public static void main(String[] args) throws Exception {
        PathTest test = new PathTest();
        test.getPath();
    }


    public void getPath() throws Exception{
        File file1 = new File(this.getClass().getResource("/").getPath());
        System.out.println("file1：" + file1);

        File file2 = new File(this.getClass().getResource("").getPath());
        System.out.println("file2：" + file2);

        File file3 = new File("");
        System.out.println("file3：" + file3.getCanonicalPath());

    }

}
