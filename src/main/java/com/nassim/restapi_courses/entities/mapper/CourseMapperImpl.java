package com.nassim.restapi_courses.entities.mapper;

import com.nassim.restapi_courses.entities.course.Course;
import com.nassim.restapi_courses.entities.dto.AddCourseDto;
import com.nassim.restapi_courses.entities.dto.CourseDto;

public class CourseMapperImpl implements CourseMapper{
    @Override
    public Course addCourseDtoToCourse(AddCourseDto addCourseDto) {
        Course course = new Course();

        course.setTitle(addCourseDto.getTitle());
        course.setDescription(addCourseDto.getDescription());
        course.setPrice(addCourseDto.getPrice());

        return null;
    }

    @Override
    public CourseDto courseToCourseDto(Course course) {
        return new CourseDto(course);
    }
}
