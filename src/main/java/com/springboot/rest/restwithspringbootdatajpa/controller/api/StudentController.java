package com.springboot.rest.restwithspringbootdatajpa.controller.api;

import com.springboot.rest.restwithspringbootdatajpa.service.StudentService;
import com.springboot.rest.restwithspringbootdatajpa.student.dto.StudentDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentList = new ArrayList<>();
        studentService.getAllStudents().stream().forEach(studentEntity -> studentList.add(new StudentDto(studentEntity)));
        return studentList;
    }

}
