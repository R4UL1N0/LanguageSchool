package br.com.raulino.LanguageSchool.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.services.ClassroomService;
import br.com.raulino.LanguageSchool.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/school")
@Tag(name = "Classrooms")
public class ClassroomController {

    private StudentService studentService;

    private ClassroomService classroomService;


    public ClassroomController(StudentService studentService, ClassroomService classroomService) {
        this.studentService = studentService;
        this.classroomService = classroomService;
    }

    @GetMapping("/classrooms")
    @Operation(summary = "Find All Classrooms")
    public ResponseEntity<List<ClassroomDTO>> findAllClassrooms() {
        return ResponseEntity.ok(classroomService.findAllClassrooms());
    }

    @GetMapping("/classrooms/{id}")
    @Operation(summary = "Find Classroom By Id")
    public ResponseEntity<ClassroomDTO> findClassroomById(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.findClassroomById(id));
    }

    // @GetMapping("/classrooms/search")
    // public ResponseEntity<ClassroomDTO> findClassroomByClassCode(@PathVariable String classcode) throws Exception {
    //     return ResponseEntity.ok(classroomService.findClassroomByClassCode(classcode));
    // }

    @GetMapping("classrooms/{id}/students")
    @Operation(summary = "Find All The Classroom's Students")
    public ResponseEntity<List<StudentDTO>> findStudentsByClassroomId(@PathVariable Long id) throws Exception {
        if (!classroomService.doesClassroomExist(id)) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(studentService.findStudentsByClassroomId(id));
    }

    @PostMapping("/classrooms")
    @Operation(summary = "Create New Class")
    public ResponseEntity<ClassroomDTO> createClassroom(@RequestBody ClassroomDTO cDTO) throws Exception {
        return ResponseEntity.ok(classroomService.createClassroom(cDTO));
    }

    @PutMapping("/classrooms/{id}")
    @Operation(summary = "Update Classroom's Info")
    public ResponseEntity<ClassroomDTO> updateClassroom(@PathVariable Long id, @RequestBody ClassroomDTO cDTO) throws Exception {
        return ResponseEntity.ok(classroomService.updateClassroom(id, cDTO));
    }

    @DeleteMapping("/classrooms/{id}")
    @Operation(summary = "Delete Classroom")
    public ResponseEntity<ClassroomDTO> deleteClassroom(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.deleteClassroom(id));
    }
}
