package com.lpc.domain;

import java.util.List;

/**
 * Created by liupengcheng1 on 2017/2/6.
 */
public class MethodParam {

    private Class type;
    private String name;
    private String value;
    private List<MethodParam> fields;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<MethodParam> getFields() {
        return fields;
    }

    public void setFields(List<MethodParam> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        String str = "";
        str += "name = " + name + "\n";
        str += "type = " + type + "\n";
        if (null != fields) {
            for (MethodParam param : fields) {
                str += "================\n" + param.toString() + "\n";
            }
        }
        return str;
    }

}
