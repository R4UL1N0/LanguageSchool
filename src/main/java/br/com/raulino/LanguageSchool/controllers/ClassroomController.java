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
import br.com.raulino.LanguageSchool.services.ClassroomService;

@RestController
@RequestMapping("/api/school")
public class ClassroomController {

    private ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/classrooms")
    public ResponseEntity<List<ClassroomDTO>> findAllClassrooms() {
        return ResponseEntity.ok(classroomService.findAllClassrooms());
    }

    @GetMapping("/classrooms/{id}")
    public ResponseEntity<ClassroomDTO> findClassroomById(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.findClassroomById(id));
    }

    @PostMapping("/classrooms")
    public ResponseEntity<ClassroomDTO> createClassroom(@RequestBody ClassroomDTO cDTO) {
        return ResponseEntity.ok(classroomService.createClassroom(cDTO));
    }

    @PutMapping("/classrooms/{id}")
    public void updateClassroom() {
        
    }

    @DeleteMapping("/classrooms/{id}")
    public ResponseEntity<ClassroomDTO> deleteClassroom(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.deleteClassroom(id));
    }
}
