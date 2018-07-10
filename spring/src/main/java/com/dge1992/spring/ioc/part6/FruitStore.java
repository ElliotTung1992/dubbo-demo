package com.dge1992.spring.ioc.part6;

/**
 * 水果商店
 */
public class FruitStore {
    private Apple apple;
    private Orange orange;
    private Pear pear;

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Orange getOrange() {
        return orange;
    }

    public void setOrange(Orange orange) {
        this.orange = orange;
    }

    public Pear getPear() {
        return pear;
    }

    public void setPear(Pear pear) {
        this.pear = pear;
    }

    @Override
    public String toString() {
        return "FruitStore{" +
                "apple=" + apple +
                ", orange=" + orange +
                ", pear=" + pear +
                '}';
    }
}
