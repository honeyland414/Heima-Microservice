package com.example.orderservice.domain;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
    private String phone;
}
