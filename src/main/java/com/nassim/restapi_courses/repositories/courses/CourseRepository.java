package com.nassim.restapi_courses.repositories.courses;

import com.nassim.restapi_courses.entities.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
