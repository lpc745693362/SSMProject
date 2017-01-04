package com.lpc.other.annotation;

/**
 * Created by liupengcheng1 on 2016/12/30.
 */
public class AnnoService {

    @NeedTest(value = true)
    public void addAnno(){
        System.out.println("增加注解。。。");
    }

    @NeedTest(value = false)
    public void deleteAnno(){
        System.out.println("删除注解。。。");
    }

}
