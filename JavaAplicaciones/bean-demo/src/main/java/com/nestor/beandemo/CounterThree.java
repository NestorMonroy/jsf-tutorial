package com.nestor.beandemo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped //Short-lived
public class CounterThree {
    private int value = 0;
    public CounterThree() {
    }
    public String increment() {
        value++;
        return "counter_three";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
