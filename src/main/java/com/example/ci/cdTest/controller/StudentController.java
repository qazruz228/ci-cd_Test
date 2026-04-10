package com.example.ci.cdTest.controller;

import com.example.ci.cdTest.entity.Student;
import com.example.ci.cdTest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;


    @PostMapping("/create")
    public String createStudent(@RequestParam String name){
        Student student = new Student();
        student.setName(name);
        studentRepository.save(student);
        return student.getName();
    }


    @GetMapping("/get")
    public String getStudent(String name){

        List<Student> students = studentRepository.findByName(name);

        return students.toString();


    }





}
