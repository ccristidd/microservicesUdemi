package com.example.restservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int age;
    private String address;

    public Student withName(String name) {
        this.name = name;
        return this;
    }

    public Student withAge(int age) {
        this.age = age;
        return this;
    }

    public Student withAddress(String address) {
        this.address = address;
        return this;
    }



}
