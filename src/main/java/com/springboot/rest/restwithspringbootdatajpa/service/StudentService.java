package com.springboot.rest.restwithspringbootdatajpa.service;

import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;

import java.util.List;

public interface StudentService {
    List<StudentEntity> getAllStudents();

    StudentEntity createStudent(StudentCreateDTO studentCreateDTO);

    void updateStudent(Long id, StudentCreateDTO studentCreateDTO);

    void deleteStudent(Long id);
}
