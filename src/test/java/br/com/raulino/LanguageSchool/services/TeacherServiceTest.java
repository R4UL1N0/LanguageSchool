package br.com.raulino.LanguageSchool.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.entities.Teacher;
import br.com.raulino.LanguageSchool.repositories.TeacherRepository;
import br.com.raulino.LanguageSchool.utils.UtilsTest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest implements IServiceTest{
    
    @InjectMocks
    private TeacherService teacherService;

    @Mock
    private TeacherRepository teacherRepository;

    private static Teacher tEntity = Converter.teacherDTOtoTeacherEntity(UtilsTest.Teacher_DTO);

    @Override
    @Test
    public void test_findAll() {
        

        when(teacherRepository.findAll()).thenReturn(List.of());

        assertEquals(List.of(), teacherService.findAllTeachers());

        when(teacherRepository.findAll()).thenReturn(List.of(tEntity));

        assertEquals(1, teacherService.findAllTeachers().size());
    }

    @Override
    @Test
    public void test_findById() {
        when(teacherRepository.findById(1L)).thenReturn(Optional.of(tEntity));

        assertTrue(teacherService.findTeacherById(1L).getName() ==  UtilsTest.Teacher_DTO.getName());

        when(teacherRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> teacherService.findTeacherById(1L));
    }

    @Override
    @Test
    public void test_create() throws Exception {

        when(teacherRepository.save(tEntity)).thenReturn(tEntity);

        teacherService.createTeacher(UtilsTest.Teacher_DTO);

        verify(teacherRepository, times(1)).save(tEntity);
    }

    @Override
    @Test
    @Transactional
    public void test_update() throws Exception {

        var opTeacher = Optional.of(tEntity);

        when(teacherRepository.findById(1L)).thenReturn(opTeacher);
        
        UtilsTest.Teacher_DTO.setName("Rodrigo");

        var updatedTeacher = UpdateEntity.teacher(tEntity, UtilsTest.Teacher_DTO);

        when(teacherRepository.save(updatedTeacher)).thenReturn(updatedTeacher);
        
        var result = teacherService.updateTeacher(1L, UtilsTest.Teacher_DTO);

        assertEquals("Rodrigo", result.getName());
    }

    @Override
    @Test
    public void test_delete() {

         var opTeacher = Optional.of(tEntity);

        when(teacherRepository.findById(1L)).thenReturn(opTeacher);
        
        teacherService.deleteTeacher(1L);

        verify(teacherRepository, times(1)).delete(opTeacher.get());

        when(teacherRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class , () -> teacherService.deleteTeacher(1L));
    }


}
