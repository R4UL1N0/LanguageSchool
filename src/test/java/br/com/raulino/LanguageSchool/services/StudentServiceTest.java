package br.com.raulino.LanguageSchool.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.entities.Student;
import br.com.raulino.LanguageSchool.repositories.ClassroomRepository;
import br.com.raulino.LanguageSchool.repositories.StudentRepository;
import br.com.raulino.LanguageSchool.utils.UtilsTest;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest implements IServiceTest{
    
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @Override
    @Test
    public void test_findAll() {

        when(studentRepository.findAll()).thenReturn(List.of());

        assertEquals(List.of(), studentService.findAllStudents());

        when(studentRepository.findAll()).thenReturn(List.of(Converter.studentDTOtoStudentEntity(UtilsTest.STUDENT_DTO)));

        assertEquals(1, studentService.findAllStudents().size());

    }

    @Override
    @Test
    public void test_findById() {

        var opStudent = Optional.of(Converter.studentDTOtoStudentEntity(UtilsTest.STUDENT_DTO));
        
        when(studentRepository.findById(UtilsTest.STUDENT_DTO.getId())).thenReturn(opStudent);

        assertTrue(studentService.findStudentById(UtilsTest.STUDENT_DTO.getId()).getName() == "James", "It should give me a DTO with the same Student name");

        when(studentRepository.findById(UtilsTest.STUDENT_DTO.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> studentService.findStudentById(UtilsTest.STUDENT_DTO.getId()), "Student not found");
    }

    @Override
    @Test
    public void test_create() throws Exception {

        var opClassroom = Optional.of(Converter.classroomDTOtoClassroomEntity(UtilsTest.CLASSROOM_DTO));
        Student sEntity = Converter.studentDTOtoStudentEntity(UtilsTest.STUDENT_DTO);
        
        when(classroomRepository.existsById(UtilsTest.STUDENT_DTO.getClassroomId())).thenReturn(false);

        assertThrows(Exception.class, () -> studentService.createStudent(UtilsTest.STUDENT_DTO), "Classroom doesn't exist");

        when(classroomRepository.existsById(UtilsTest.STUDENT_DTO.getClassroomId())).thenReturn(true);

        when(classroomRepository.findById(1L)).thenReturn(opClassroom);

        when(studentRepository.save(sEntity)).thenReturn(sEntity);

        assertTrue(studentService.createStudent(UtilsTest.STUDENT_DTO) instanceof StudentDTO);

    }

    @Override
    @Test
    public void test_update() throws Exception {

        var opStudent = Optional.of(Converter.studentDTOtoStudentEntity(UtilsTest.STUDENT_DTO));
        
        when(studentRepository.findById(UtilsTest.STUDENT_DTO.getId())).thenReturn(opStudent);

        UtilsTest.STUDENT_DTO.setLastName("Carmelito");

        var updatedStudent = UpdateEntity.student(opStudent.get(), UtilsTest.STUDENT_DTO);

        when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);

        var result = studentService.updateStudent(UtilsTest.STUDENT_DTO.getId(), UtilsTest.STUDENT_DTO);

        assertTrue(result.getLastName() == "Carmelito");
    }

    @Override
    @Test
    public void test_delete() {

        var opStudent = Optional.of(Converter.studentDTOtoStudentEntity(UtilsTest.STUDENT_DTO));
        
        when(studentRepository.findById(UtilsTest.STUDENT_DTO.getId())).thenReturn(opStudent);
        
        studentService.deleteStudent(UtilsTest.STUDENT_DTO.getId());

        verify(studentRepository, times(1)).delete(opStudent.get());
    }

    @Test
    public void test_findStudentsByClassroom() {

        var sEntity = Converter.studentDTOtoStudentEntity(UtilsTest.STUDENT_DTO);

        sEntity.setClassroom(Converter.classroomDTOtoClassroomEntity(UtilsTest.CLASSROOM_DTO));

        when(studentRepository.findAll()).thenReturn(List.of(sEntity));

        assertEquals(1, studentService.findStudentsByClassroomId(UtilsTest.CLASSROOM_DTO.getId()).size());
    }

    



}
