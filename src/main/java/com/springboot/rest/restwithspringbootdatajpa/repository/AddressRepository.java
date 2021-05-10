package com.springboot.rest.restwithspringbootdatajpa.repository;

import com.springboot.rest.restwithspringbootdatajpa.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
