package com.nestor.beandemo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped //Solo la session
public class Counter {
    private int value = 0;

    public String increment() {
        value++;
        return "counter";
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
