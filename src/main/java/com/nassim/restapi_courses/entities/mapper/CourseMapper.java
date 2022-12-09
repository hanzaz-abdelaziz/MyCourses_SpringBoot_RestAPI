package com.nassim.restapi_courses.entities.mapper;

import com.nassim.restapi_courses.entities.course.Course;
import com.nassim.restapi_courses.entities.dto.AddCourseDto;
import com.nassim.restapi_courses.entities.dto.CourseDto;

public interface CourseMapper {

    Course addCourseDtoToCourse(AddCourseDto addCourseDto);

    CourseDto courseToCourseDto(Course course);


}
