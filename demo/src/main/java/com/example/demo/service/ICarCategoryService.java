package com.example.demo.service;

import com.example.demo.entity.CarCategory;
import com.example.demo.form.carCategory.CreatingCarCategoryForm;
import com.example.demo.form.carCategory.UpdatingCarCategoryForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarCategoryService {
    Page<CarCategory> getAllCarCategories(Pageable pageable);
    CarCategory getCarCategoryById(int id);
    void createCarCategory(CreatingCarCategoryForm form);
    void updateCarCategory(UpdatingCarCategoryForm form);
    void deleteCarCategory(int id);
    void moveToTrash(int id);
    void restoreFromTrash(int id);
}
