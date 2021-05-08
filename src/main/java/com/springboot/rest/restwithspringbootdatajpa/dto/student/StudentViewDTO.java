package com.springboot.rest.restwithspringbootdatajpa.dto.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentViewDTO {
    @JsonIgnore
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private Date modifiedAt;
    @Transient
    private String fullName;

    public StudentViewDTO(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.firstName = studentEntity.getFirstName();
        this.lastName = studentEntity.getLastName();
        this.email = studentEntity.getEmail();
        this.createdAt = studentEntity.getCreatedAt();
        this.modifiedAt = studentEntity.getModifiedAt();
        this.fullName =  studentEntity.getFirstName() + " " + studentEntity.getLastName();
    }
}
