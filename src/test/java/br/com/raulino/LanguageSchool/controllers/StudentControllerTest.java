package br.com.raulino.LanguageSchool.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import jakarta.persistence.EntityNotFoundException;

import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.services.StudentService;
import br.com.raulino.LanguageSchool.utils.UtilsTest;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;


    @Test 
    public void test_findAllStudents_returnOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
            .get("/api/school/students")
            .contentType(MediaType.APPLICATION_JSON)   
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_findStudentById_returnOk() throws Exception {

        Long studentId = UtilsTest.CLASSROOM_DTO.getId();

        when(studentService.findStudentById(studentId)).thenReturn(UtilsTest.STUDENT_DTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/school/students/{id}", studentId).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("James"));
    }

    @Test
    public void test_findStudentById_returnNotFound() throws Exception {

        Long studentId = UtilsTest.CLASSROOM_DTO.getId();

        when(studentService.findStudentById(studentId)).thenThrow(new EntityNotFoundException("Student not found"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/school/students/{id}", studentId).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("404"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Student not found"));
    }

    @Test
    public void test_updateStudent_returnOk() throws Exception {

        Long studentId = UtilsTest.CLASSROOM_DTO.getId();

        when(studentService.updateStudent(studentId, UtilsTest.STUDENT_DTO)).thenReturn(UtilsTest.STUDENT_DTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/school/students/{id}", studentId).contentType(MediaType.APPLICATION_JSON))    
            .andExpect(MockMvcResultMatchers.status().isOk())        
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lucas"));
    }

    @Test 
    void test_updateStudent_withDifferentIds_BadRequest() throws Exception {
        Long studentId = 1L;
        StudentDTO s = new StudentDTO();
        s.setName("Lucas");
        s.setId(studentId);

        when(studentService.updateStudent(2L, s)).thenThrow(new Exception("Ids supplied don't match."));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/school/students/{id}", studentId).contentType(MediaType.APPLICATION_JSON))    
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("400"));
            // .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ids supplied don't match."));
    }

    @Test
    public void test_deleteStudent_returnOk() throws Exception {

        Long studentId = 1L;
        StudentDTO s = new StudentDTO();
        s.setId(studentId);
        s.setName("Lucas");

        when(studentService.deleteStudent(studentId)).thenReturn(s);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/school/students/{id}", studentId).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lucas"));
    }
    
}
