package com.tuwaiq.week8_day4_schoolmanagement.DTOOUT;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class CourseDTO {
    private Integer id;
    private String courseName;
    private String teacherName;
}
