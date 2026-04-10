package com.example.ci.cdTest.repository;

import com.example.ci.cdTest.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {

    public List<Student> findByName(String name);

}
