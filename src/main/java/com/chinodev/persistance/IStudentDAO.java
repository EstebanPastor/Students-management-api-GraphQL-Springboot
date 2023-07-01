package com.chinodev.persistance;
import com.chinodev.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentDAO extends CrudRepository<Student, Long>{

}
