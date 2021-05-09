package com.springboot.rest.restwithspringbootdatajpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Table(name = "address")
@Entity
public class AddressEntity extends TrackedEntity {

    private String street;
    private String city;

    // This for Bi-Directional association
    @OneToOne(mappedBy = "addressEntity")
    private StudentEntity studentEntity;
}
