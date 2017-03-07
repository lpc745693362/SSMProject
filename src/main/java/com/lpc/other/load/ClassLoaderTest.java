package com.lpc.other.load;

/**
 * 类加载器
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + appClassLoader);

        ClassLoader extensionClassLoader = appClassLoader.getParent();
        System.out.println("系统类加载器的父类加载器 - 扩展类加载器：" + extensionClassLoader);

        ClassLoader bootStrapClassLoader = extensionClassLoader.getParent();
        System.out.println("扩展类加载器的父类加载器 - 引导类加载器：" + bootStrapClassLoader);


    }

}
