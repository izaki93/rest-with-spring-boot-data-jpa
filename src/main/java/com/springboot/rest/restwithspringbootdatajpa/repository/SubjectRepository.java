package com.springboot.rest.restwithspringbootdatajpa.repository;

import com.springboot.rest.restwithspringbootdatajpa.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
