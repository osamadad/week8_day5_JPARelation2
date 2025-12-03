package com.tuwaiq.week8_day4_schoolmanagement.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Sorry, the teacher name can't be empty, please try again")
    @Size(max = 15, message = "Sorry, the teacher name can't be more than 15 characters, please try again")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
    @NotNull(message = "Sorry, the teacher age can't be empty, please try again")
    @Positive(message = "Sorry, the teacher age must be above 0, please try again")
    @Min(value = 22,message = "Sorry, the teacher age can't be less than 22 years old, please try again")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "Sorry, the teacher email can't be empty, please try again")
    @Email(message = "Sorry, the teacher email must be a valid email, please try again")
    @Size(max = 35, message = "Sorry, the teacher email can't be more than 35 characters, please try again")
    @Column(columnDefinition = "varchar(35) not null unique")
    private String email;
    @NotNull(message = "Sorry, the teacher salary can't be empty, please try again")
    @Positive(message = "Sorry, the teacher salary must be above 0, please try again")
    @Column(columnDefinition = "int not null")
    private Integer salary;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
