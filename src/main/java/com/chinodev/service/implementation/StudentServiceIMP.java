package com.chinodev.service.implementation;
import org.springframework.transaction.annotation.Transactional;
import com.chinodev.entities.Student;
import com.chinodev.persistance.IStudentDAO;
import com.chinodev.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class StudentServiceIMP implements IStudentService {
    @Autowired
    private IStudentDAO studentDAO;
    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
       return studentDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentDAO.findAll();
    }

    @Override
    public void create(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentDAO.deleteById(id);
    }



}
