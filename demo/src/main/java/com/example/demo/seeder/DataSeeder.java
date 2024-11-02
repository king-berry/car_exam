package com.example.demo.seeder;

import com.example.demo.entity.CarCategory;
import com.example.demo.entity.Role;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Account;
import com.example.demo.entity.Car;
import com.example.demo.repository.ICarRepository;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ICarCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private ICarCategoryRepository carCategoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (accountRepository.count() == 0) {
            // Seed initial data
            Account account1 = new Account();
            account1.setUsername("user1");
            account1.setPassword("password1");
            account1.setRole(Role.USER);

            Account account2 = new Account();
            account2.setUsername("user2");
            account2.setPassword("password2");
            account2.setRole(Role.ADMIN);

            accountRepository.save(account1);
            accountRepository.save(account2);
        }
        // Seed data for Car
        if (carRepository.count() == 0) {
            CarCategory category = new CarCategory();
            category.setName("Sedan");
            carCategoryRepository.save(category);

            Car car1 = new Car();
            car1.setName("Toyota Corolla");
            car1.setImage("toyota_corolla.jpg");
            car1.setPrice("20000");
            car1.setInformation("A reliable car");
            car1.setDetailInformation("Detailed information about Toyota Corolla");
            car1.setYearOfManufacturer(2020);
            car1.setSeatingCapacity(5);
            car1.setCarFuel("Petrol");
            car1.setPlaceOfManufacture("Japan");
            car1.setTransmission("Automatic");
            car1.setStatus("Available");
            car1.setCreateAt(new Date(System.currentTimeMillis()));
            car1.setCarCategory(category);

            Car car2 = new Car();
            car2.setName("Honda Civic");
            car2.setImage("honda_civic.jpg");
            car2.setPrice("22000");
            car2.setInformation("A sporty car");
            car2.setDetailInformation("Detailed information about Honda Civic");
            car2.setYearOfManufacturer(2019);
            car2.setSeatingCapacity(5);
            car2.setCarFuel("Petrol");
            car2.setPlaceOfManufacture("Japan");
            car2.setTransmission("Manual");
            car2.setStatus("Available");
            car2.setCreateAt(new Date(System.currentTimeMillis()));
            car2.setCarCategory(category);

            carRepository.save(car1);
            carRepository.save(car2);
        }
        }
}