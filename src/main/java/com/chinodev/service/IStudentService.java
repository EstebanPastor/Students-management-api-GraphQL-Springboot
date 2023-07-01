package com.chinodev.service;

import com.chinodev.entities.Student;

import java.util.List;

public interface IStudentService {
    Student findById(Long id);
    List<Student> findAll();
    void create(Student student);
    void deleteById(Long id);

    void createStudent(Student student);
}
