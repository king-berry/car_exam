package com.example.demo.service;

import com.example.demo.dto.CustomerReceiveAlertPriceDto;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerReceiveAlertPriceService {
    Page<CustomerReceiveAlertPriceDto> findAll(CustomerReceiveAlertPriceFilterForm form, Pageable pageable);

    CustomerReceiveAlertPriceDto create (CustomerReceiveAlertPriceCreateForm form);

    CustomerReceiveAlertPriceDto update (CustomerReceiveAlertPriceUpdateForm form);

    void deleteById(int id);
}
