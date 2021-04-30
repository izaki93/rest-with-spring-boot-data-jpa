package com.springboot.rest.restwithspringbootdatajpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
@MappedSuperclass
public abstract class IdEntity implements Serializable {

    //use on class when id column should be renamed
    ///@AttributeOverride(name="NAME", column=@Column(name="PROJECT_NAME"))

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "uniqueidentifier")
    private Long id;

}
