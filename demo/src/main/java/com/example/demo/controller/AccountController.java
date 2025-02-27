package com.example.demo.controller;


import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //    @GetMapping("/all")
//    public ResponseEntity<Page<Account>> getAllAccounts(Pageable pageable) {
//        Page<Account> accounts = accountService.getAll(pageable);
//        return ResponseEntity.ok(accounts);
//    }
    @GetMapping("/all")
    public ResponseEntity<Page<Account>> getAllAccounts(
            Pageable pageable,
            @RequestParam(name = "search", required = false) String search
    ) {
        Page<Account> accounts = accountService.getAll(pageable, search);
        return ResponseEntity.ok(accounts);
    }
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }


    @GetMapping("/username/{username}")
    public ResponseEntity<?> getAccountByUsername(@PathVariable String username) {
        Optional<Account> account = accountService.findByUsername(username);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Integer id) {
        Optional<Account> account = accountService.getAccountById(id);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Integer id, @Valid @RequestBody Account updatedAccount) {
        Optional<Account> account = accountService.updateAccount(id, updatedAccount);

        if (account.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "Cập nhật thành công");
            response.put("data", account.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {
        boolean deleted = accountService.deleteAccount(id);
        if (deleted) {
            return ResponseEntity.ok("Xóa thành công");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
    }
}
