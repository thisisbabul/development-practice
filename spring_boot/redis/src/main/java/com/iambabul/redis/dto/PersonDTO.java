package com.iambabul.redis.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {
    private String id;
    private String name;
    private int age;
}
