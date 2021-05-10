package com.springboot.rest.restwithspringbootdatajpa.dto.student;

import com.fasterxml.jackson.annotation.*;
import com.springboot.rest.restwithspringbootdatajpa.dto.TrackedDTO;
import com.springboot.rest.restwithspringbootdatajpa.dto.address.AddressViewDTO;
import com.springboot.rest.restwithspringbootdatajpa.dto.subject.SubjectViewDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.StudentEntity;
import lombok.Data;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentViewDTO extends TrackedDTO {
    @JsonIgnore
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;
    @Transient
    private String fullName;
    private AddressViewDTO addressDTO;
    @JsonProperty("learningSubjects")
    private List<SubjectViewDTO> subjectDTOList;

    public StudentViewDTO(StudentEntity studentEntity) {
        super(studentEntity);
        this.id = studentEntity.getId();
        this.firstName = studentEntity.getFirstName();
        this.lastName = studentEntity.getLastName();
        this.email = studentEntity.getEmail();
        this.fullName = studentEntity.getFirstName() + " " + studentEntity.getLastName();
        if(studentEntity.getAddressEntity() != null) {
            this.addressDTO = new AddressViewDTO(studentEntity.getAddressEntity());
        }

        if(studentEntity.getLearningSubjects() != null){
            subjectDTOList = new ArrayList<>();
            studentEntity.getLearningSubjects().stream().forEach(subjectEntity ->
                    subjectDTOList.add(new SubjectViewDTO(subjectEntity)));
        }

    }
}
