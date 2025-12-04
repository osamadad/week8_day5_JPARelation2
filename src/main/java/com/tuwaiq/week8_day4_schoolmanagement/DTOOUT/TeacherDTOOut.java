package com.tuwaiq.week8_day4_schoolmanagement.DTOOUT;

import com.tuwaiq.week8_day4_schoolmanagement.Model.Course;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class TeacherDTOOut {
    private Integer id;
    private String teacherName;
    private Integer teacherAge;
    private String teacherEmail;
    private Integer teacherSalary;
    private String teacherAddressArea;
    private String teacherAddressStreet;
    private String teacherAddressBuildingNumber;
    private List<Course> courses;

}
