package br.com.raulino.LanguageSchool.controllers;

import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/school")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public void getAllStudents() {

    }
    @GetMapping("/students/{id}")
    public void getStudentById(@PathVariable String id) {

    }

    @PostMapping("/students")
    public void createStudent(@RequestBody StudentDTO studentDTO) {

    }

    @PutMapping("students/{id}")
    public void updateStudent(@PathVariable String id) {

    }

    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable String id) {

    }




}
