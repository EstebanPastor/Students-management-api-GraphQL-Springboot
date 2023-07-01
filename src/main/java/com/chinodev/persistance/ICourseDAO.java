package com.chinodev.persistance;

import com.chinodev.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseDAO extends CrudRepository<Course, Long> {

}
