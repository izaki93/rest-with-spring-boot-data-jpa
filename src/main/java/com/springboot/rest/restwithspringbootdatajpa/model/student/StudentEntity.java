package com.springboot.rest.restwithspringbootdatajpa.model.student;

import com.springboot.rest.restwithspringbootdatajpa.model.TrackedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "student")
public class StudentEntity extends TrackedEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
}
