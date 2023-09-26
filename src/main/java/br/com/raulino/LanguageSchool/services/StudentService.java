package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.entities.Student;
import br.com.raulino.LanguageSchool.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> findAllStudents() {

        return studentRepository.findAll().stream().map(Converter::studentEntityToStudentDTO).toList();

    }

    public StudentDTO findStudentById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow();

        StudentDTO sDTO = Converter.studentEntityToStudentDTO(student);

        return sDTO;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = Converter.studentDTOtoStudentEntity(studentDTO);
        student.setCreatedAt(LocalDateTime.now());
        Student s = studentRepository.save(student);

        return Converter.studentEntityToStudentDTO(s);

    }

    public StudentDTO updateStudent(Long id, StudentDTO sDTO) throws Exception {
        if (sDTO.getId() != null && sDTO.getId() != id) throw new Exception("Ids supplied don't match.");

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
