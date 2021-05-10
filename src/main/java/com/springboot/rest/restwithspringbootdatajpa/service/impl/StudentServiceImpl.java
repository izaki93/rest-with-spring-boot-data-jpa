package com.springboot.rest.restwithspringbootdatajpa.service.impl;

import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.AddressEntity;
import com.springboot.rest.restwithspringbootdatajpa.model.StudentEntity;
import com.springboot.rest.restwithspringbootdatajpa.model.SubjectEntity;
import com.springboot.rest.restwithspringbootdatajpa.repository.AddressRepository;
import com.springboot.rest.restwithspringbootdatajpa.repository.StudentRepository;
import com.springboot.rest.restwithspringbootdatajpa.repository.SubjectRepository;
import com.springboot.rest.restwithspringbootdatajpa.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private AddressRepository addressRepository;
    private SubjectRepository subjectRepository;
    private ModelMapper modelMapper;

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Page<StudentEntity> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public StudentEntity createStudent(StudentCreateDTO studentCreateDTO) {
        StudentEntity studentEntity = new StudentEntity(studentCreateDTO);

        AddressEntity addressEntity= new AddressEntity();
        addressEntity.setStreet(studentCreateDTO.getAddressDTO().getStreet());
        addressEntity.setCity(studentCreateDTO.getAddressDTO().getCity());
        addressEntity = addressRepository.save(addressEntity);

        studentEntity.setAddressEntity(addressEntity);
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);

        List<SubjectEntity> subjectEntities = new ArrayList<>();
        if(studentCreateDTO.getLearningSubjects() != null){
            studentCreateDTO.getLearningSubjects().stream()
                    .forEach(subjectDTO ->{
                        SubjectEntity subjectEntity = new SubjectEntity();
                        subjectEntity.setSubjectName(subjectDTO.getSubjectName());
                        subjectEntity.setMarksObtained(subjectDTO.getMarksObtained());
                        subjectEntity.setStudentEntity(savedStudentEntity);
                        subjectEntities.add(subjectEntity);
                    });
            subjectRepository.saveAll(subjectEntities);
        }
        savedStudentEntity.setLearningSubjects(subjectEntities);
        return savedStudentEntity;
    }

    @Override
    public void updateStudent(Long id, StudentCreateDTO studentCreateDTO) {
        StudentEntity entity = studentRepository.getOne(id);
        modelMapper.map(studentCreateDTO, entity);
        studentRepository.save(entity);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentEntity> getByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public StudentEntity getByFirstNameAndLastName(String firstName, String lastName) {
        /** call Query Methods **/
        // return studentRepository.findByFirstNameAndLastName(firstName,lastName);

        /** call Java Persistence Query Language (JPQL) Methods **/
        return studentRepository.getByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public List<StudentEntity> getByFirstNameContains(String firstName) {
        return studentRepository.findByFirstNameContains(firstName);
    }

    @Override
    public List<StudentEntity> startsWith(String firstName) {
        return studentRepository.findByFirstNameStartsWith(firstName);
    }

    @Override
    public void updateFirstNameWithJPQL(Long id, String firstName) {
        studentRepository.updateFirstName(id, firstName);
    }

    @Override
    public void deleteByFirstNameWithJPQL(String firstName) {
        studentRepository.deleteByFirstName(firstName);
    }

    @Override
    public List<StudentEntity> getByCity(String city) {
        /** call Query Methods **/
        // return studentRepository.findByAddressEntity_City(city);
        /** call Java Persistence Query Language (JPQL) Methods **/
        return studentRepository.getByAddressEntity_City(city);
    }
}
