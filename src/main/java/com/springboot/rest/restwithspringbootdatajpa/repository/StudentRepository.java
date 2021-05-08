package com.springboot.rest.restwithspringbootdatajpa.repository;

import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findByFirstName(String firstName);
    List<StudentEntity> findByFirstNameAndLastName(String firstName, String lastName);
    List<StudentEntity> findByFirstNameContains(String firstName);
    List<StudentEntity> findByFirstNameStartsWith(String firstName);
}
