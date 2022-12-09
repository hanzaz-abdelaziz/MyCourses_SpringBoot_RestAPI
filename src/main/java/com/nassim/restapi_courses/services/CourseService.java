package com.nassim.restapi_courses.services;

import com.nassim.restapi_courses.entities.dto.AddCourseDto;
import com.nassim.restapi_courses.entities.dto.CourseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    ResponseEntity<List<CourseDto>> findAll();

    ResponseEntity<CourseDto> create(AddCourseDto addCourseDto);

    ResponseEntity<CourseDto> findById(Long id);

    ResponseEntity<CourseDto> update(Long id, AddCourseDto addCourseDto);

    ResponseEntity<String> remove(Long id);

}
