package com.tuwaiq.week8_day4_schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Sorry, course name can't be empty, please try again")
    @Size(max = 10, message = "Sorry, course name can't be more than 10 characters, please try again")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;
    @ManyToOne
    @JsonIgnore
    private Teacher teacher;
}
