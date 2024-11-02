package com.example.demo.service.impl;

import com.example.demo.entity.CarCategory;
import com.example.demo.form.carCategory.CreatingCarCategoryForm;
import com.example.demo.form.carCategory.UpdatingCarCategoryForm;
import com.example.demo.repository.ICarCategoryRepository;
import com.example.demo.service.ICarCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CarCategoryService implements ICarCategoryService {

    @Autowired
    private ICarCategoryRepository carCategoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<CarCategory> getAllCarCategories(Pageable pageable) {
        return carCategoryRepository.findAll(pageable);
    }

    @Override
    public CarCategory getCarCategoryById(int id) {
        return carCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
    }

    @Override
    public void createCarCategory(CreatingCarCategoryForm form) {
        CarCategory carCategory = modelMapper.map(form , CarCategory.class);
        carCategoryRepository.save(carCategory);
    }

    @Override
    public void updateCarCategory(UpdatingCarCategoryForm form) {
        CarCategory carCategory = modelMapper.map(form , CarCategory.class);
        carCategoryRepository.save(carCategory);
    }

    @Override
    public void deleteCarCategory(int id) {
        carCategoryRepository.deleteById(id);
    }

    @Override
    public void moveToTrash(int id) {

    }

    @Override
    public void restoreFromTrash(int id) {
    }
}
