package com.reef.demo_store.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class MarketErrorDto {
    private int status;
    private String message;
    private Date timestamp;

    public MarketErrorDto(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
