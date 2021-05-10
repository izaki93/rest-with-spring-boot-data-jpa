package com.springboot.rest.restwithspringbootdatajpa.model;

import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "studentEntity")
    private List<SubjectEntity> learningSubjects;

    public void addLearningSubject(SubjectEntity subject){
        if(learningSubjects == null) {
            learningSubjects = new ArrayList<>();
        }
        learningSubjects.add(subject);
    }
    public StudentEntity(StudentCreateDTO studentCreateDTO) {
        this.firstName = studentCreateDTO.getFirstName();
        this.lastName = studentCreateDTO.getLastName();
        this.email = studentCreateDTO.getEmail();
        this.fullName = studentCreateDTO.getFirstName() + " " + studentCreateDTO.getLastName();
    }
}
