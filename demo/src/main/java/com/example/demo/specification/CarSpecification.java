package com.example.demo.specification;

import com.example.demo.entity.Car;
import com.example.demo.form.car.CarFilterForm;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CarSpecification {
    private static final String NAME = "name";

    public static Specification<Car> buildWhere(CarFilterForm form) {
        if (form == null) {
            return null;
        }
        Specification<Car> wherename = new SpecificationImpl(NAME, form.getSearch());
        return Specification.where(wherename);
    }

    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Car> {
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case NAME:
                    return criteriaBuilder.like(root.get("name"),"%" + value + "%");
            }
            return null;
        }
    }

}
