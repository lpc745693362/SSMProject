package com.lpc.constant;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * Created by liupengcheng1 on 2017/2/6.
 */
public class ClassUtils {

    private ClassUtils() {
    }

    /**
     * 获取方法参数名称，按给定的参数类型匹配方法
     */
    public static String[] getMethodParamNames(Class<?> clazz, String method, Class<?>... paramTypes) {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc;
        CtMethod cm = null;
        try {
            cc = pool.get(clazz.getName());
            String[] paramTypeNames = new String[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                paramTypeNames[i] = paramTypes[i].getName();
            }
            cm = cc.getDeclaredMethod(method, pool.get(paramTypeNames));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return getMethodParamNames(cm);
    }

    /**
     * 获取方法参数名称，匹配同名的某一个方法
     */
    public static String[] getMethodParamNames(Class<?> clazz, String method) {
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(ClassUtils.class);
        pool.insertClassPath(classPath);
        CtClass cc;
        CtMethod cm = null;
        try {
            cc = pool.get(getOrgClassName(clazz.getName()));
            cm = cc.getDeclaredMethod(method);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return getMethodParamNames(cm);
    }

    /**
     * 获取方法参数名称
     */
    protected static String[] getMethodParamNames(CtMethod cm) {
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            System.out.println("attr is null");
        }

        String[] paramNames = null;
        try {
            paramNames = new String[cm.getParameterTypes().length];
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++) {
            paramNames[i] = attr.variableName(i + pos);
        }
        return paramNames;
    }

    public static String getOrgClassName(String className) {
        if (-1 == className.indexOf('$')) {
            return className;
        } else {
            return className.substring(0, className.indexOf('$'));
        }
    }

}
