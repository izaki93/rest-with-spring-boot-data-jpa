package com.springboot.rest.restwithspringbootdatajpa.model.student;

import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.TrackedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "student")
public class StudentEntity extends TrackedEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Transient
    private String fullName;

    public StudentEntity(StudentCreateDTO studentCreateDTO) {
        this.firstName = studentCreateDTO.getFirstName();
        this.lastName = studentCreateDTO.getLastName();
        this.email = studentCreateDTO.getEmail();
        this.fullName =  studentCreateDTO.getFirstName() + " " + studentCreateDTO.getLastName();
    }
}
