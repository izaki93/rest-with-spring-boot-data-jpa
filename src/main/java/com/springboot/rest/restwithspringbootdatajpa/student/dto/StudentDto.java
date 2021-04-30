package com.springboot.rest.restwithspringbootdatajpa.student.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {
    @JsonIgnore
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private Date modifiedAt;

    public StudentDto(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.firstName = studentEntity.getFirstName();
        this.lastName = studentEntity.getLastName();
        this.email = studentEntity.getEmail();
        this.createdAt = studentEntity.getCreatedAt();
        this.modifiedAt = studentEntity.getModifiedAt();
    }
}
