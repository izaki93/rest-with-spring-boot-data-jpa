package com.springboot.rest.restwithspringbootdatajpa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.rest.restwithspringbootdatajpa.model.AddressEntity;
import com.springboot.rest.restwithspringbootdatajpa.model.StudentEntity;
import com.springboot.rest.restwithspringbootdatajpa.model.SubjectEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.springboot.rest.restwithspringbootdatajpa.shared.SharedConstants.DATE_FORMAT_PATTERN_DASH_YYYY_MM_DD;

@Data
@NoArgsConstructor
public class TrackedDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_PATTERN_DASH_YYYY_MM_DD)
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_PATTERN_DASH_YYYY_MM_DD)
    private Date modifiedAt;

    public TrackedDTO(StudentEntity studentEntity) {
        this.createdAt = studentEntity.getCreatedAt();
        this.modifiedAt = studentEntity.getModifiedAt();
    }

    public TrackedDTO(AddressEntity addressEntity) {
        this.createdAt = addressEntity.getCreatedAt();
        this.modifiedAt = addressEntity.getModifiedAt();
    }

    public TrackedDTO(SubjectEntity subjectEntity) {
        this.createdAt = subjectEntity.getCreatedAt();
        this.modifiedAt = subjectEntity.getModifiedAt();
    }
}
