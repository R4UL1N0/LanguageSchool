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

        return studentRepository.findAll().stream().map(Converter::studentEntityToStudentDTO).toList();

    }

    public StudentDTO findStudentById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow();

        StudentDTO sDTO = Converter.studentEntityToStudentDTO(student);

        return sDTO;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = Converter.studentDTOtoStudentEntity(studentDTO);
        System.out.printf("From studentService: %s", student.getAddress().getCountry());
        Student s = studentRepository.save(student);

        return Converter.studentEntityToStudentDTO(s);

    }

    public void updateStudent(StudentDTO sDTO) {

    }

    public StudentDTO deleteStudent(Long id) {
        Student s = studentRepository.findById(id).orElseThrow();

        studentRepository.delete(s);

        return Converter.studentEntityToStudentDTO(s);
    }
}
