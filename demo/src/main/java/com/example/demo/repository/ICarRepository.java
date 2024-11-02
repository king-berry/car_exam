package com.example.demo.repository;

import com.example.demo.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ICarRepository extends JpaRepository<Car,Integer> {

    @Override
    <S extends Car> S save(S entity);

    Page<Car> findAll(Specification<Car> where, Pageable pageable);

    Optional<Car> findByName(String carName);
}
