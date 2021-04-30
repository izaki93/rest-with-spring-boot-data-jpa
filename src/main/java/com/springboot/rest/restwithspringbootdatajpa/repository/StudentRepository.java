package com.springboot.rest.restwithspringbootdatajpa.repository;

import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
