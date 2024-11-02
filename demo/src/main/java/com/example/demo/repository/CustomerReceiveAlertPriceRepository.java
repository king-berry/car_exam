package com.example.demo.repository;

import com.example.demo.dto.CustomerReceiveAlertPriceDto;
import com.example.demo.entity.CustomerReceiveAlertPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CustomerReceiveAlertPriceRepository
        extends JpaRepository<CustomerReceiveAlertPrice, Integer>, JpaSpecificationExecutor<CustomerReceiveAlertPrice> {
    Optional<CustomerReceiveAlertPriceDto> findById(int id);
}
