package com.example.demo.controller;

import com.example.demo.dto.CarCategoryDTO;
import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarCategory;
import com.example.demo.form.car.CreatingCarForm;
import com.example.demo.form.car.UpdatingCarForm;
import com.example.demo.form.carCategory.CreatingCarCategoryForm;
import com.example.demo.form.carCategory.UpdatingCarCategoryForm;
import com.example.demo.service.ICarCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin("*")
public class CarCategoryController {
    @Autowired
    private ICarCategoryService carCategoryService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public Page<CarCategoryDTO> getAllCarCategories(Pageable pageable){
        Page<CarCategory> carCategoryPage = carCategoryService.getAllCarCategories(pageable);
        List<CarCategory> carCategories = carCategoryPage.getContent();
        List<CarCategoryDTO> carCategoryDTOS =
                carCategories.stream().map(carCategory ->
                        modelMapper.map(carCategory, CarCategoryDTO.class))
                        .collect(Collectors.toList());
        return new PageImpl<>(carCategoryDTOS, pageable,carCategoryPage.getTotalElements());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCarCategoryById(@PathVariable int id) {
        try {
            CarCategory carCategory = carCategoryService.getCarCategoryById(id);
            CarCategoryDTO carCategoryDTO = modelMapper.map(carCategory, CarCategoryDTO.class);
            return new ResponseEntity<>(carCategoryDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<String> createCarCategory(@RequestBody CreatingCarCategoryForm form) {
        carCategoryService.createCarCategory(form);
        return new ResponseEntity<>("Create successfully", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCarCategory(@RequestBody UpdatingCarCategoryForm form) {
        carCategoryService.updateCarCategory(form);
        return new ResponseEntity<>("Update successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarCategory(@PathVariable int id) {
        carCategoryService.deleteCarCategory(id);
        return new ResponseEntity<>("Delete successfully", HttpStatus.CREATED);
    }
}
