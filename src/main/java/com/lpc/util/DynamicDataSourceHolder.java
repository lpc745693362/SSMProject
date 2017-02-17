package com.lpc.util;

/**
 * Created by liupengcheng1 on 2017/2/17.
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name){
        holder.set(name);
    }

    public static String getDataSource(){
        return holder.get();
    }

}
