package com.chinodev.controller;

import com.chinodev.entities.Course;
import com.chinodev.entities.Student;
import com.chinodev.graphql.InputStudent;
import com.chinodev.service.ICourseService;
import com.chinodev.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id){
        Long studentId = Long.parseLong(id);

        return studentService.findById(studentId);

    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent) {

        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        studentService.createStudent(student);

        return student;

    }

    @MutationMapping(name = "deleteStudentById")
    public String deleteById(@Argument(name= "studentId") String id) {
        studentService.deleteById(Long.parseLong(id));

        return "The student with id " + id + " was deleted from the database";
    }

}
