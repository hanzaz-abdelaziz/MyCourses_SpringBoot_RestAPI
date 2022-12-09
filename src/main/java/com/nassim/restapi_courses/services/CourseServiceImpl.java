package com.nassim.restapi_courses.services;

import com.nassim.restapi_courses.entities.course.Course;
import com.nassim.restapi_courses.entities.dto.AddCourseDto;
import com.nassim.restapi_courses.entities.dto.CourseDto;
import com.nassim.restapi_courses.entities.mapper.CourseMapper;
import com.nassim.restapi_courses.entities.mapper.CourseMapperImpl;
import com.nassim.restapi_courses.errors.CourseNotFoundException;
import com.nassim.restapi_courses.repositories.courses.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private static final CourseMapper mapper = new CourseMapperImpl();
    private final CourseRepository courseRepository;

    @Autowired
    private CourseServiceImpl(CourseRepository courseRepository){
            this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<List<CourseDto>> findAll() {
        List<Course> courses = this.courseRepository.findAll();
        //reference type mapper::courseToCourseDto
        List<CourseDto> courseDtoList = courses.stream().map(mapper::courseToCourseDto).collect(Collectors.toList());
        return new ResponseEntity<>(courseDtoList, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<CourseDto> findById(Long id) {
        Optional<Course> course = this.courseRepository.findById(id);

        if(course.isEmpty()){
             throw new CourseNotFoundException("Course Id Not Found");
        }
        CourseDto courseDto = mapper.courseToCourseDto(course.get());

        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> create(AddCourseDto addCourseDto) {
        final Course course = mapper.addCourseDtoToCourse(addCourseDto);
        Course createdCourse = this.courseRepository.save(course);
        CourseDto courseDto = mapper.courseToCourseDto(createdCourse);
        return new ResponseEntity<>(courseDto, HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<CourseDto> update(Long id, AddCourseDto newCourse) {

        Optional<Course> course = this.courseRepository.findById(id);
        if(course.isEmpty()){
            throw new CourseNotFoundException("Course Id Not Found");
        }
        Course existedCourse = course.get();
        existedCourse.setTitle(newCourse.getTitle());
        existedCourse.setDescription(newCourse.getDescription());
        existedCourse.setPrice(newCourse.getPrice());
        Course updatedCourse = this.courseRepository.save(existedCourse);
        CourseDto courseDto = mapper.courseToCourseDto(updatedCourse);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> remove(Long id) {
        boolean exists = this.courseRepository.existsById(id);

        if(!exists){
            throw new CourseNotFoundException("Course Not Removed Id Invalid!!");
        }

        this.courseRepository.deleteById(id);
        return new ResponseEntity<>("Course has been deleted", HttpStatus.NO_CONTENT);
    }
}
