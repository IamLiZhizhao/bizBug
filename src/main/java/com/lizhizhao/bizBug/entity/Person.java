package com.lizhizhao.bizBug.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Person {

//    @EqualsAndHashCode.Exclude
    private String name;

    private String identity;

    public Person(String name, String identity) {
        this.name = name;
        this.identity = identity;
    }
}