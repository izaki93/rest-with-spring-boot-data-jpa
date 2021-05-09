package com.springboot.rest.restwithspringbootdatajpa.dto.subject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.rest.restwithspringbootdatajpa.dto.TrackedDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.SubjectEntity;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectCreateDTO extends TrackedDTO {
    private String subjectName;
    private Double marksObtained;
}
