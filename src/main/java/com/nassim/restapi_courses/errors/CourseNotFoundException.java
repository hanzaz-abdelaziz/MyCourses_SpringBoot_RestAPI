package com.nassim.restapi_courses.errors;

public class CourseNotFoundException extends  RuntimeException{

    public CourseNotFoundException(String message){
        super(message);
    }
}
