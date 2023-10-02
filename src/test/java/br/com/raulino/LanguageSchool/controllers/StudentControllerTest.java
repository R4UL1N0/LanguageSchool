package br.com.raulino.LanguageSchool.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.services.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @Test
    public void test_findAllStudents() {

        List<StudentDTO> list = new ArrayList<>();

        when(studentService.findAllStudents()).thenReturn(list);

        assertEquals(ResponseEntity.ok(List.of()), studentController.getAllStudents());
        verify(studentService, times(1)).findAllStudents();
       
    }
    
}
