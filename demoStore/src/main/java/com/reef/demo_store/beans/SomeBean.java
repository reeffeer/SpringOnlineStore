package com.reef.demo_store.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SomeBean {
    private int value;

    public void increment() {
        value++;
    }
}