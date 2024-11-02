package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "CustomerReceiveAlertPrice")
public class CustomerReceiveAlertPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname", length = 50, nullable = false)
    private String fullName;

    @Column(name = "phoneNumber", length = 11, nullable = false)
    private String phoneNumber;

    @Column(name = "paymentMethod", length = 50, nullable = false)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;
}
