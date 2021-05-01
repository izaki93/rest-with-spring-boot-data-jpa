package com.springboot.rest.restwithspringbootdatajpa.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentCreateDTO {

    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;
}
