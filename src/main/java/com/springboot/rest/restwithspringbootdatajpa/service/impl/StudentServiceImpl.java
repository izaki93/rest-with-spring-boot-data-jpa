package com.springboot.rest.restwithspringbootdatajpa.service.impl;

import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import com.springboot.rest.restwithspringbootdatajpa.repository.StudentRepository;
import com.springboot.rest.restwithspringbootdatajpa.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }
}
