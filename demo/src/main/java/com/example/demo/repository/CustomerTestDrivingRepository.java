package com.example.demo.repository;

import com.example.demo.entity.CustomerTestDriving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTestDrivingRepository extends JpaRepository<CustomerTestDriving, Integer> {

    Page<CustomerTestDriving> findByFullNameContainingIgnoreCaseOrPhoneNumberContaining (String fullName, String phoneNumber, Pageable pageable);

}
