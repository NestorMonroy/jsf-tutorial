package com.nestor.beandemo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Counter {
    private int value = 0;

    public String increment() {
        value++;
        return "counter_one";
    }

    public Counter() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
