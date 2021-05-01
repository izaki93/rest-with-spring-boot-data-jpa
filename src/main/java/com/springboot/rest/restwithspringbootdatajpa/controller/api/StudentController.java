package com.springboot.rest.restwithspringbootdatajpa.controller.api;

import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import com.springboot.rest.restwithspringbootdatajpa.service.StudentService;
import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentViewDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.springboot.rest.restwithspringbootdatajpa.controller.ControllerConstants.API_PREFIX;

@AllArgsConstructor
@RestController
@RequestMapping(value = StudentController.API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    public static final String API_PATH = API_PREFIX + "/students";

    private StudentService studentService;

    @GetMapping
    public List<StudentViewDTO> getAllStudents() {
        List<StudentViewDTO> studentList = new ArrayList<>();
        studentService.getAllStudents().stream().forEach(studentEntity -> studentList.add(new StudentViewDTO(studentEntity)));
        return studentList;
    }

    @PostMapping
    public StudentViewDTO addStudent(@RequestBody @Valid StudentCreateDTO studentCreateDTO) {
        StudentEntity studentEntity = studentService.createStudent(studentCreateDTO);
        return new StudentViewDTO(studentEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentCreateDTO studentCreateDTO) {
        studentService.updateStudent(id, studentCreateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }



}
