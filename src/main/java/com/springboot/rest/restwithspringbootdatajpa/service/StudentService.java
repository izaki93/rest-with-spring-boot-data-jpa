package com.springboot.rest.restwithspringbootdatajpa.service;

import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<StudentEntity> getAllStudents();

    Page<StudentEntity> getAllStudents(Pageable pageable);

    StudentEntity createStudent(StudentCreateDTO studentCreateDTO);

    void updateStudent(Long id, StudentCreateDTO studentCreateDTO);

    void deleteStudent(Long id);

    List<StudentEntity> getByFirstName(String firstName);

    StudentEntity getByFirstNameAndLastName(String firstName, String lastName);

    List<StudentEntity> getByFirstNameContains(String firstName);

    List<StudentEntity> startsWith(String firstName);

    void updateFirstNameWithJPQL(Long id, String firstName);

    void deleteByFirstNameWithJPQL(String firstName);
}
