package com.lpc.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import javax.json.Json;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liupengcheng1 on 2017/2/6.
 */
public class ServiceDesc {

    private String beanName;
    private String methodName;
    private List<MethodParam> params;
    private String jsonResult;

    public ServiceDesc(String beanName, String methodName) {
        this.beanName = beanName;
        this.methodName = methodName;
    }

    public ServiceDesc() {
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<MethodParam> getParams() {
        return params;
    }

    public void setParams(List<MethodParam> params) {
        this.params = params;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public List<MethodParam> initParams(){
        if(null == params){
            params = new ArrayList<MethodParam>();
        }
        return params;
    }

    public void clearParams(){
        params = null;
    }

    public Object[] getParamValues(){
        Object args[] = new Object[params.size()];
        for (int i = 0; i< params.size(); i++){
            MethodParam param = params.get(i);
            String value = param.getValue();
            if(StringUtils.isEmpty(value)){
                value = null;
            }
            Class clazz = param.getType();
            args[i] = JSON.parseObject(value.toString(), clazz);
        }
        return args;
    }

    @Override
    public String toString() {
        String str = "";
        str += "beanName = " + beanName + "\n";
        str += "methodName = " + methodName + "\n";
        if (null != params) {
            for (MethodParam param : params) {
                str += "================\n" + param.toString() + "\n";
            }
        }
        return str;
    }

}
