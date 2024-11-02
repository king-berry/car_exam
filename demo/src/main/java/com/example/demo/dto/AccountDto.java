package com.example.demo.dto;

import com.example.demo.entity.Role;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}
