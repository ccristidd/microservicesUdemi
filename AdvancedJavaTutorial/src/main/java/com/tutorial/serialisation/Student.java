package com.tutorial.serialisation;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable{
    private static final long serialVersionUuid = 1L;

    private String name;
    private String gender;
    private int age;
    private String address;
    transient private int value; //it will not get serialized

}
