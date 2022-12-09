package com.nassim.restapi_courses.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CustomErrorResponse {

    String httpStatusCode;
    String message;
}
