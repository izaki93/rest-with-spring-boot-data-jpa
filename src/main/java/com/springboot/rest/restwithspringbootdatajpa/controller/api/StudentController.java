package com.springboot.rest.restwithspringbootdatajpa.controller.api;

import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentCreateDTO;
import com.springboot.rest.restwithspringbootdatajpa.dto.student.StudentViewDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.student.StudentEntity;
import com.springboot.rest.restwithspringbootdatajpa.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
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
    private ModelMapper modelMapper;

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

    @GetMapping("/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentViewDTO> getByFirstName(@PathVariable String firstName) {
        List<StudentViewDTO> studentList = new ArrayList<>();
        studentService.getByFirstName(firstName).stream().forEach(studentEntity -> studentList.add(new StudentViewDTO(studentEntity)));
        return studentList;
    }

    @GetMapping("/firstNameAndLastName")
    @ResponseStatus(HttpStatus.OK)
    public StudentViewDTO getByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        StudentEntity studentEntity = studentService.getByFirstNameAndLastName(firstName, lastName);
        return new StudentViewDTO(studentEntity);
    }

    @GetMapping("getAllStudentsWithPaging")
    public Page<StudentViewDTO> getAllStudents(@PageableDefault @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<StudentViewDTO> response = studentService.getAllStudents(pageable).map(StudentViewDTO::new);
        return response;
    }

    @GetMapping("/like/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentViewDTO> getByFirstNameLike(@PathVariable String firstName) {
        List<StudentViewDTO> studentList = new ArrayList<>();
        studentService.getByFirstNameContains(firstName).stream().forEach(studentEntity -> studentList.add(new StudentViewDTO(studentEntity)));
        return studentList;
    }

    @GetMapping("/starts-with/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentViewDTO> getByFirstNameStartsWith(@PathVariable String firstName) {
        List<StudentViewDTO> studentList = new ArrayList<>();
        studentService.startsWith(firstName).stream().forEach(studentEntity -> studentList.add(new StudentViewDTO(studentEntity)));
        return studentList;
    }

    @PutMapping("/update-first-name/{id}/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> updateFirstName(@PathVariable Long id, @PathVariable String firstName) {
        studentService.updateFirstNameWithJPQL(id, firstName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-by-first-name/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteByFirstName(@PathVariable String firstName) {
        studentService.deleteByFirstNameWithJPQL(firstName);
        return ResponseEntity.ok().build();
    }

}
