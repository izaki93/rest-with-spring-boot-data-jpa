package com.springboot.rest.restwithspringbootdatajpa.model.student;

import com.springboot.rest.restwithspringbootdatajpa.model.TrackedEntity;
import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public StudentEntity(StudentCreateDTO studentCreateDTO) {
        this.firstName = studentCreateDTO.getFirstName();
        this.lastName = studentCreateDTO.getLastName();
        this.email = studentCreateDTO.getEmail();
    }
}
