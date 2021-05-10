package com.springboot.rest.restwithspringbootdatajpa.repository;

import com.springboot.rest.restwithspringbootdatajpa.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    /** Query Methods **/
    List<StudentEntity> findByFirstName(String firstName);
    StudentEntity findByFirstNameAndLastName(String firstName, String lastName);
    List<StudentEntity> findByFirstNameContains(String firstName);
    List<StudentEntity> findByFirstNameStartsWith(String firstName);
    List<StudentEntity> findByAddressEntity_City(String city);

    /** Java Persistence Query Language (JPQL) Methods **/
    //@Query("FROM StudentEntity where firstName = ?1 and lastName = ?2")
    @Query("FROM StudentEntity where firstName = :first_name and lastName = :lastName")
    StudentEntity getByFirstNameAndLastName(@Param("first_name") String firstName, String lastName);

    @Query("FROM StudentEntity s where s.addressEntity.city = :city")
    List<StudentEntity> getByAddressEntity_City(String city);
    /**
     * https://www.baeldung.com/spring-data-jpa-modifying-annotation
     * https://stackoverflow.com/questions/43665090/why-do-we-have-to-use-modifying-annotation-for-queries-in-data-jpa

     * >> The @Modifying annotation is used to enhance the @Query annotation to execute
            not only SELECT queries but also INSERT, UPDATE, DELETE, and even DDL queries.

     * >> when we don't put the @Modifying along with @Transactional annotation
          on the DML (INSERT, UPDATE, DELETE) query
          we get an InvalidDataAccessApiUsage exception
          The error message is pretty clear – the query is Not supported for DML operations.
     **/
    @Transactional
    @Modifying
    @Query("update StudentEntity set firstName= :firstName where id = :id")
    void updateFirstName(Long id, String firstName);

    @Transactional
    @Modifying
    @Query("delete from StudentEntity where firstName= :firstName")
    void deleteByFirstName(String firstName);
}
