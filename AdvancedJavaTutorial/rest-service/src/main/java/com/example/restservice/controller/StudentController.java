package com.example.restservice.controller;


import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/{id}")
    Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).get();

    }

    @GetMapping("/student")
    List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

}
