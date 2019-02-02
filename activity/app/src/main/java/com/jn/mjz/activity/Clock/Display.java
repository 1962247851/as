package com.jn.mjz.activity.Clock;

public class Display {
    private int limit, value;
    private Boolean b = false;

    Display(int value, int limit) {
        this.value = value;
        this.limit = limit;
    }

    public String getValue() {
        return Integer.toString(value);
    }

    public Display setValue(int value) {
        this.value = value;
        return this;
    }

    public Display increase() {
        value += 1;
        b = false;
        if (value == limit) {
            value = 0;
            b = true;
        }
        return this;
    }

    public Boolean isMax(){
        return b;
    }
}
