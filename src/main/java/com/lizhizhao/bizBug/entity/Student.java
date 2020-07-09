package com.lizhizhao.bizBug.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Data
@AllArgsConstructor
@Slf4j
public class Student implements Comparable<Student>{
    private int id;
    private String name;

    @Override
    public int compareTo(Student other){
        int result = Integer.compare(id, other.id);
        if (result==0)
            log.info("this {} == other {}", this, other);
        return result;
    }

//    @Override
//    public int compareTo(Student other){
//        return Comparator.comparing(Student::getName)
//                .thenComparingInt(Student::getId)
//                .compare(this, other);
//    }
}