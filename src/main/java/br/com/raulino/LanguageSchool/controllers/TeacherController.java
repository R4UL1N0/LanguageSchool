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
import br.com.raulino.LanguageSchool.models.dtos.TeacherDTO;
import br.com.raulino.LanguageSchool.services.ClassroomService;
import br.com.raulino.LanguageSchool.services.TeacherService;

@RestController
@RequestMapping("/api/school")
public class TeacherController {

    private ClassroomService classroomService;

    private TeacherService teacherService;


    public TeacherController(ClassroomService classroomService, TeacherService teacherService) {
        this.classroomService = classroomService;
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDTO>> findAllTeachers() {
        
        return ResponseEntity.ok(teacherService.findAllTeachers());

    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<TeacherDTO> findTeacherById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.findTeacherById(id));
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO tDTO) {
        return ResponseEntity.ok(teacherService.createTeacher(tDTO));
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO tDTO) throws Exception {
        return ResponseEntity.ok(teacherService.updateTeacher(id, tDTO));
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<TeacherDTO> deleteTeacher(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }

    @GetMapping("teachers/{id}/classrooms") 
    public ResponseEntity<List<ClassroomDTO>> findClassroomsByTeacher(@PathVariable Long id) throws Exception {
        if (!teacherService.doesTeacherExist(id)) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(classroomService.findAllClassroomsByTeacherId(id));
    }
}
