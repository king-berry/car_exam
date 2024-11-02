package com.example.demo.controller;

import com.example.demo.dto.CustomerReceiveAlertPriceDto;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceUpdateForm;
import com.example.demo.service.ICustomerReceiveAlertPriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CustomerReceiveAlertPriceController {
    @Autowired
    private ICustomerReceiveAlertPriceService service;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping("/customerReceiveAlertPrice")
    public Page<CustomerReceiveAlertPriceDto> findAll(CustomerReceiveAlertPriceFilterForm form, Pageable pageable) {
        return service.findAll(form, pageable);
    }

    @PostMapping("/customerReceiveAlertPrice")
    public CustomerReceiveAlertPriceDto create (@RequestBody CustomerReceiveAlertPriceCreateForm form) {
        return service.create(form);
    }

    @PutMapping("/customerReceiveAlertPrice/{id}")
    public CustomerReceiveAlertPriceDto update (@RequestBody CustomerReceiveAlertPriceUpdateForm form, @PathVariable("id") int id) {
        form.setId(id);
        return service.update(form);
    }

    @DeleteMapping("/customerReceiveAlertPrice/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
