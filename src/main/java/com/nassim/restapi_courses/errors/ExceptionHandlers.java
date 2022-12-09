package com.nassim.restapi_courses.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public final ResponseEntity<CustomErrorResponse> handlerCourseNotFoundException(final CourseNotFoundException ex){

    CustomErrorResponse customErrorResponse = new CustomErrorResponse("404", ex.getMessage());

      return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }
}
