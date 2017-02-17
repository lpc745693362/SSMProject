package com.lpc.other.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liupengcheng1 on 2017/2/8.
 */
public class Test {

    public static void main(String[] args) throws Exception {

//        Class<Apple> clazz = (Class<Apple>) Class.forName("com.lpc.other.clazz.Apple");

        Class<Apple> clazz = Apple.class;

        System.out.println(clazz.getName() + " | " + clazz.getSimpleName());

//        Field[] fields = clazz.getFields(); // 获取类中public修饰的属性
        Field[] fields = clazz.getDeclaredFields(); // 获取类中所有的属性
        for(Field field : fields){
            System.out.println(field.getName() + " | " + field.getType());
        }

        System.out.println("--------------------------");

//        Method[] methods = clazz.getMethods(); // 获取所有public方法，包括其继承和实现接口中的方法
        Method[] methods = clazz.getDeclaredMethods(); // 获取所有该类中声明的方法包括protected,private修饰的方法
        for (Method method : methods){
            System.out.println(method.getName() + " | " + method.getReturnType());

            Class[] classes = method.getParameterTypes();
            for (Class cls : classes){
                System.out.println(cls.getName());
            }
            System.out.println("=====================");
        }

    }

}
