package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.entities.Student;
import br.com.raulino.LanguageSchool.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> findAllStudents() {

        return studentRepository.findAll().stream().map((student) -> {
            return new StudentDTO();
        }).toList();

    }

    public StudentDTO findStudentById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow();

        return new StudentDTO();
    }

    public void saveStudent(StudentDTO studentDTO) {
        Student student = Converter.studentDTOtoStudentEntity(studentDTO);

    }
}
