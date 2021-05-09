package com.springboot.rest.restwithspringbootdatajpa.model;

import com.springboot.rest.restwithspringbootdatajpa.dto.subject.SubjectCreateDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "subject")
@Entity
public class SubjectEntity extends TrackedEntity {

    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "marks_obtained")
    private Double marksObtained;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    public SubjectEntity(SubjectCreateDTO subjectDTO) {
        this.subjectName = subjectDTO.getSubjectName();
        this.marksObtained = subjectDTO.getMarksObtained();
    }
}
