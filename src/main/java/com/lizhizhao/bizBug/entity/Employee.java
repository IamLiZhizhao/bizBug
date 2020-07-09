package com.lizhizhao.bizBug.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {
    private String company;
    public Employee(String name, String identity, String company) {
        super(name, identity);
        this.company = company;
    }
}