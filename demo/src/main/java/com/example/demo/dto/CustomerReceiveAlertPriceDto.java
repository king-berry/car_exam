package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerReceiveAlertPriceDto {
    private int id;
    private String fullName;
    private String phoneNumber;
    private String carName;
    private String paymentMethod;
}
