package com.lpc.controller;

import com.lpc.constant.ClassUtils;
import com.lpc.constant.SpringContext;
import com.lpc.domain.MethodParam;
import com.lpc.domain.ServiceDesc;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liupengcheng1 on 2017/2/6.
 */
public class ServiceInvoker {

    private ServiceDesc serviceDesc;

    public ServiceInvoker(ServiceDesc serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public void getParametersOfService() throws IllegalArgumentException {
        if (StringUtils.isEmpty(serviceDesc.getBeanName())) {
            throw new IllegalArgumentException("beanName不能为空!");
        }
        if (StringUtils.isEmpty(serviceDesc.getMethodName())) {
            throw new IllegalArgumentException("方法名不能为空!");
        }

        Object object = null;
        try {
            object = getBean(serviceDesc.getBeanName());
        } catch (Exception e) {
            throw new IllegalArgumentException("beanName: " + serviceDesc.getBeanName() + "不存在");
        }

        Method method = getMethod(object, serviceDesc.getMethodName());
        if (method == null) {
            throw new IllegalArgumentException("方法名: " + serviceDesc.getMethodName() + "不存在");
        }

        String[] fileNames = ClassUtils.getMethodParamNames(getBeanType(serviceDesc.getBeanName()), serviceDesc.getMethodName());
        if (null == serviceDesc.getParams()) {
            serviceDesc.initParams();
            for (int i = 0; i < fileNames.length; i++) {
                MethodParam methodParam = new MethodParam();
                serviceDesc.getParams().add(methodParam);
            }
        }
        for (int i = 0; i < fileNames.length; i++) {
            serviceDesc.getParams().get(i).setName(fileNames[i]);
        }

        Class[] fieldTypes = getMethodParameterTypes(method);
        for (int i = 0; i < fieldTypes.length; i++) {
            Class clazz = fieldTypes[i];
            serviceDesc.getParams().get(i).setType(clazz);
            if (!clazz.getName().startsWith("java")) {
                List<MethodParam> methodParams = makeFields(fieldTypes[i]);
                serviceDesc.getParams().get(i).setFields(methodParams);
            }
        }
    }

    public String invoke(){
        try{
            Object object = getBean(serviceDesc.getBeanName());
            Object result = invokeMethod(object, serviceDesc.getMethodName(), serviceDesc.getParamValues());
            if(result != null){
                ObjectMapper mapper = new ObjectMapper();
                String jsonResult = mapper.writeValueAsString(result);
                serviceDesc.setJsonResult(jsonResult);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return serviceDesc.getJsonResult();
    }

    private Object invokeMethod(Object object, String methodName, Object[] args) throws Exception{
        Class clazz = object.getClass();
        Class[] parameterTypes = new Class[args.length];
        for(int i = 0; i < parameterTypes.length; i++){
            parameterTypes[i] = args[i].getClass();
        }
        Method method = clazz.getMethod(methodName, parameterTypes);
        return method.invoke(object, args);
    }

    private List<MethodParam> makeFields(Class fieldType) {
        List<MethodParam> methodParams = new ArrayList<MethodParam>();
        Field[] fields = fieldType.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            MethodParam methodParam = new MethodParam();
            methodParam.setName(field.getName());
            methodParam.setType(field.getType());
            methodParams.add(methodParam);
        }
        return methodParams;
    }

    private Class[] getMethodParameterTypes(Method method) {
        Class[] classes = method.getParameterTypes();
        return classes;
    }

    private Method getMethod(Object object, String methodName) {
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }

    private Object getBean(String beanName) {
        return SpringContext.getSpringBean(beanName);
    }

    private Class getBeanType(String beanName) {
        return SpringContext.getSpringBeanType(beanName);
    }

}
