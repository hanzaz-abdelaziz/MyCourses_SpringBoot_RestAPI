package com.nassim.restapi_courses.entities.dto;

import com.nassim.restapi_courses.entities.course.Course;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CourseDto {

    private final Course mCourse;

    public CourseDto(Course course){
        this.mCourse = course;
    }


    public String getTitle(){
        return this.mCourse.getTitle();
    }

    public String getDescription(){
        return this.mCourse.getDescription();
    }

    public BigDecimal getPrice(){
        BigDecimal price = this.mCourse.getPrice();

        return price.setScale(2, RoundingMode.HALF_UP);
    }



}
