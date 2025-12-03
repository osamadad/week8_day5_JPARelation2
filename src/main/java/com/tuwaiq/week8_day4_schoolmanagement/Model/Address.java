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
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(35) not null")
    private String area;
    @Column(columnDefinition = "varchar(35) not null")
    private String street;
    @Column(columnDefinition = "varchar(10) not null")
    private String buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
