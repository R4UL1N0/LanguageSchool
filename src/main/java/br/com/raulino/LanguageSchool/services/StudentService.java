package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.entities.Student;
import br.com.raulino.LanguageSchool.repositories.ClassroomRepository;
import br.com.raulino.LanguageSchool.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    


    public StudentService(StudentRepository studentRepository, ClassroomRepository classroomRepository) {
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }

    public List<StudentDTO> findAllStudents() {

        return studentRepository.findAll().stream().map(Converter::studentEntityToStudentDTO).toList();

    }

    public List<StudentDTO> findStudentsByClassroomId(Long classId) {
        var classStudents = studentRepository.findAll().stream().filter(s -> s.getClassroom().getId() == classId).toList();
        return classStudents.stream().map((s) -> Converter.studentEntityToStudentDTO(s)).toList();
    }

    public StudentDTO findStudentById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));

        StudentDTO sDTO = Converter.studentEntityToStudentDTO(student);

        return sDTO;
    }

    public StudentDTO createStudent(StudentDTO sDTO) throws Exception {
        Student student = Converter.studentDTOtoStudentEntity(sDTO);
        student.setCreatedAt(LocalDateTime.now());

        if (sDTO.getClassroomId() != null && !classroomRepository.existsById(sDTO.getClassroomId())) throw new Exception("Classroom doesn't exist.");
        if (sDTO.getClassroomId() != null) student.setClassroom(classroomRepository.findById(sDTO.getClassroomId()).get());

        Student s = studentRepository.save(student);
        
        return Converter.studentEntityToStudentDTO(s);

    }

    public StudentDTO updateStudent(Long id, StudentDTO sDTO) throws Exception {
        if (sDTO.getId() != null && !sDTO.getId().equals(id)) throw new Exception("Ids supplied don't match.");

        Student s = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found."));
        
        var updatedStudent = studentRepository.save(UpdateEntity.student(s, sDTO));

        return Converter.studentEntityToStudentDTO(updatedStudent);

    }

    public StudentDTO deleteStudent(Long id) {
        Student s = studentRepository.findById(id).orElseThrow();

        studentRepository.delete(s);

        return Converter.studentEntityToStudentDTO(s);
    }
}
