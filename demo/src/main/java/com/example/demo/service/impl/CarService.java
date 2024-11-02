package com.example.demo.service.impl;

import com.example.demo.entity.Car;
import com.example.demo.entity.CarCategory;
import com.example.demo.form.car.CarFilterForm;
import com.example.demo.form.car.CreatingCarForm;
import com.example.demo.form.car.UpdatingCarForm;
import com.example.demo.repository.ICarCategoryRepository;
import com.example.demo.repository.ICarRepository;
import com.example.demo.service.ICarService;
import com.example.demo.specification.CarSpecification;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private ICarCategoryRepository carCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Car> getAllCars(Pageable pageable, CarFilterForm form) {
        Specification<Car> where = CarSpecification.buildWhere(form);
        return carRepository.findAll(where, pageable);
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + id));
    }

    @Override
    public Car createCar(@Valid CreatingCarForm form) {
        Car car = modelMapper.map(form, Car.class);
        CarCategory carCategory = carCategoryRepository.findByName(form.getCarCategoryName());
        car.setCarCategory(carCategory);
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(UpdatingCarForm form) {
        Car car = modelMapper.map(form, Car.class);
        CarCategory carCategory = carCategoryRepository.findByName(form.getCarCategoryName());
        car.setCarCategory(carCategory);
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
