package com.example.hoandlee.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
}
