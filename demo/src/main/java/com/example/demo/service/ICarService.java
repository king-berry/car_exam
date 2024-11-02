package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.form.car.CarFilterForm;
import com.example.demo.form.car.CreatingCarForm;
import com.example.demo.form.car.UpdatingCarForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarService {
   Page<Car> getAllCars(Pageable pageable, CarFilterForm form);
    Car getCarById(int id);
   Car createCar(CreatingCarForm form);
   Car updateCar(UpdatingCarForm form);
   void deleteCar(int id);
}
