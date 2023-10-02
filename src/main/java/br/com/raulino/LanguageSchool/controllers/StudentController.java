package br.com.raulino.LanguageSchool.controllers;

import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@Tag(name = "Students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    @Operation(summary = "Find All Students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }
    @GetMapping("/students/{id}")
    @Operation(summary = "Find Student By Id")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @PostMapping("/students")
    @Operation(summary = "Create New Student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }

    @PutMapping("students/{id}")
    @Operation(summary = "Update Student's Info")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO sDTO) throws Exception {
        return ResponseEntity.ok(studentService.updateStudent(id, sDTO));
    }

    @DeleteMapping("students/{id}")
    @Operation(summary = "Delete Student")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

}
