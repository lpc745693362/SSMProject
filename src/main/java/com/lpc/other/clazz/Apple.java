package com.lpc.other.clazz;

/**
 * Created by liupengcheng1 on 2017/2/8.
 */
public class Apple extends Fruit {

    private int id;
    protected Long number;
    public String desc;

    public void color(String color){
        System.out.println("Apple red");
    }

    protected double price(double weight, int level){
        return weight * level;
    }

    private void desc(){
        System.out.println("Apple grows on trees");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
