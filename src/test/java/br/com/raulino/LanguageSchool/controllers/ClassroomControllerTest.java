package br.com.raulino.LanguageSchool.controllers;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.raulino.LanguageSchool.services.ClassroomService;

@SpringBootTest
@AutoConfigureMockMvc
public class ClassroomControllerTest implements IControllerTest{
    
    @MockBean
    private ClassroomService classroomService;

    @Autowired
    private MockMvc mockMvc;

    @Override
    @Test
    public void test_findAll() throws Exception {
        when(classroomService.findAllClassrooms()).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/school/teachers").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Override
    @Test
    public void test_findById() throws Exception {
    }

    @Override
    @Test
    public void test_update() throws Exception {
    }

    @Override
    @Test
    public void test_delete() throws Exception {
    }

    
}
