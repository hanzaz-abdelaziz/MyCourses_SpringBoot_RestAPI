package com.nassim.restapi_courses.entities.course;

import com.nassim.restapi_courses.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @NotNull
    @NotBlank(message = "Title is required")
    @Column(name = "title", length = 100)
    @Size(max = 100, message = "Title not be more than 100")
    private String title;

    @NotNull
    @NotBlank(message = "Description is required")
    @Column(name = "description", length = 1000)
    @Size(max = 1000, message = "Title not be more than 1000")
    private String Description;


    @NotNull(message = "Price must be not null")
    @DecimalMin("1.00")
    private BigDecimal price;

}
