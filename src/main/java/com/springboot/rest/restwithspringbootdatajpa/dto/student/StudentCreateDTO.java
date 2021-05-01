package com.springboot.rest.restwithspringbootdatajpa.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentCreateDTO {

    @JsonProperty("first_name")
    @NotBlank
    private String firstName;
    private String lastName;
    private String email;
}
