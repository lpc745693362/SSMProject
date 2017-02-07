package com.lpc.constant;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by liupengcheng1 on 2017/2/6.
 */
public class SpringContext {

    private static WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    public static Object getSpringBean(String beanName) {
        if (context == null) {
            return null;
        }
        Object object = context.getBean(beanName);
        return object;
    }

    public static Class<?> getSpringBeanType(String beanName) {
        if (context == null) {
            return null;
        }
        return context.getType(beanName);
    }

}
