package com.nassim.restapi_courses.controllers.courses;


import com.nassim.restapi_courses.entities.dto.AddCourseDto;
import com.nassim.restapi_courses.entities.dto.CourseDto;
import com.nassim.restapi_courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
          this.courseService = courseService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return this.courseService.findAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Long id){
        return this.courseService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<CourseDto> createCourse(@RequestBody AddCourseDto course){
        return  this.courseService.create(course);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody AddCourseDto course){
        return this.courseService.update(id, course);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> removeCourse(@PathVariable Long id){
        return this.courseService.remove(id);
    }


}
