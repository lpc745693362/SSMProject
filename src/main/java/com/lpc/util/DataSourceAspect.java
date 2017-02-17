package com.lpc.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * 数据源切面类：根据注解切换数据源
 */
public class DataSourceAspect {

    public void before(JoinPoint point) {
        try {
            Object target = point.getTarget(); // 获取连接点所在的目标对象
            String methodName = point.getSignature().getName(); // 获取连接点的方法签名对象

            Class<?>[] clazz = target.getClass().getInterfaces();
            Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();

            Method method = clazz[0].getMethod(methodName, parameterTypes);
            if (method != null && method.isAnnotationPresent(DataSource.class)) {
                DataSource dataSource = method.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.putDataSource(dataSource.value());
                System.out.println("this dataSource is =========== " + dataSource.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
