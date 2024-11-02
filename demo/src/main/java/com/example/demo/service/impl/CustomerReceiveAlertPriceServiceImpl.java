package com.example.demo.service.impl;

import com.example.demo.dto.CustomerReceiveAlertPriceDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.CustomerReceiveAlertPrice;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceUpdateForm;
import com.example.demo.repository.CustomerReceiveAlertPriceRepository;
import com.example.demo.repository.ICarRepository;
import com.example.demo.service.ICustomerReceiveAlertPriceService;
import com.example.demo.specification.CustomerReceiveAlertPriceSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerReceiveAlertPriceServiceImpl implements ICustomerReceiveAlertPriceService {
    @Autowired
    private CustomerReceiveAlertPriceRepository repository;

    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<CustomerReceiveAlertPriceDto> findAll(CustomerReceiveAlertPriceFilterForm form, Pageable pageable) {
        var spec = CustomerReceiveAlertPriceSpecification.buildSpec(form);
        return repository.findAll(spec, pageable)
                .map(customerReceiveAlertPriceDto ->
                        modelMapper.map(customerReceiveAlertPriceDto, CustomerReceiveAlertPriceDto.class));
    }

    @Override
    public CustomerReceiveAlertPriceDto create(CustomerReceiveAlertPriceCreateForm form) {
        CustomerReceiveAlertPrice customerReceiveAlertPrice = modelMapper.map(form, CustomerReceiveAlertPrice.class);
        Car carName = carRepository.findById(form.getCarId()).get();
        customerReceiveAlertPrice.setCar(carName);
        var savedCustomerReceiveAlertPrice = repository.save(customerReceiveAlertPrice);
        return modelMapper.map(savedCustomerReceiveAlertPrice, CustomerReceiveAlertPriceDto.class);
    }

    @Override
    public CustomerReceiveAlertPriceDto update(CustomerReceiveAlertPriceUpdateForm form) {
        CustomerReceiveAlertPrice customerReceiveAlertPrice = modelMapper.map(form, CustomerReceiveAlertPrice.class);
        var savedCustomerReceiveAlertPrice = repository.save(customerReceiveAlertPrice);
        return modelMapper.map(savedCustomerReceiveAlertPrice, CustomerReceiveAlertPriceDto.class);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
