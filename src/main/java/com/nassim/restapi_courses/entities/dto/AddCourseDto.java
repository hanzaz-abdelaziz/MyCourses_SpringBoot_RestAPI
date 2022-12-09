package com.nassim.restapi_courses.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class AddCourseDto {

       private String title;
       private String description;
       private BigDecimal price;

}
