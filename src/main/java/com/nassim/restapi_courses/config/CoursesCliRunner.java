package com.nassim.restapi_courses.config;

import com.nassim.restapi_courses.entities.course.Course;
import com.nassim.restapi_courses.entities.dto.AddCourseDto;
import com.nassim.restapi_courses.entities.mapper.CourseMapper;
import com.nassim.restapi_courses.entities.mapper.CourseMapperImpl;
import com.nassim.restapi_courses.repositories.courses.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.stream.IntStream;

@Configuration
public class CoursesCliRunner {

    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository){

        return args -> {
            CourseMapper mapper = new CourseMapperImpl();

            IntStream.rangeClosed(0,10).forEach(i -> {
                AddCourseDto addCourseDto = new AddCourseDto(
                          "course #"+i,
                        "Description for course #"+i,
                        new BigDecimal(String.valueOf(i * 100))
                );
                Course course = mapper.addCourseDtoToCourse(addCourseDto);
                courseRepository.save(course);
            });
        };
    }
}
