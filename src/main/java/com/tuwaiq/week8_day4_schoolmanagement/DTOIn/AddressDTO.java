package com.tuwaiq.week8_day4_schoolmanagement.DTOIn;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "Sorry, the address area can't be empty, please try again")
    @Size(max = 35, message = "Sorry, the address area can't be more than 35 characters, please try again")
    private String area;
    @NotEmpty(message = "Sorry, the address street can't be empty, please try again")
    @Size(max = 35, message = "Sorry, the address street can't be more than 35 characters, please try again")
    private String street;
    @NotEmpty(message = "Sorry, the address building number can't be empty, please try again")
    @Size(max = 10, message = "Sorry, the address building number can't be more than 10 characters, please try again")
    private String buildingNumber;
}
