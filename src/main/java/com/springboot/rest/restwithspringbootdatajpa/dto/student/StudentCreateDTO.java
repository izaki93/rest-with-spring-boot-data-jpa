package com.springboot.rest.restwithspringbootdatajpa.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.rest.restwithspringbootdatajpa.dto.address.AddressCreateDTO;
import com.springboot.rest.restwithspringbootdatajpa.dto.subject.SubjectCreateDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class StudentCreateDTO {

    @JsonProperty("first_name")
    @NotBlank
    private String firstName;
    private String lastName;
    private String email;
    private AddressCreateDTO addressDTO;
    private List<SubjectCreateDTO> learningSubjects;
}
