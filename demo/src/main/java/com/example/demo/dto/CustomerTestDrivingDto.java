package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CustomerTestDrivingDto {
    private int id;

    private String fullName;
    private String phoneNumber;
    private Date dateTestDriving;
    private String carName;

}
