package com.springboot.rest.restwithspringbootdatajpa.service.impl;

import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import com.springboot.rest.restwithspringbootdatajpa.repository.StudentRepository;
import com.springboot.rest.restwithspringbootdatajpa.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity createStudent(StudentCreateDTO studentCreateDTO) {
        return studentRepository.save(new StudentEntity(studentCreateDTO));
    }

    @Override
    public void updateStudent(Long id, StudentCreateDTO studentCreateDTO) {
        StudentEntity entity = studentRepository.getOne(id);
        modelMapper.map(studentCreateDTO, entity);
        studentRepository.save(entity);
    }
}
