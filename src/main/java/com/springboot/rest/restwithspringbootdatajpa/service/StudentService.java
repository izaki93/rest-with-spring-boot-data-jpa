package com.springboot.rest.restwithspringbootdatajpa.service;

import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> getAllStudents();
}
