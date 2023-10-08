package br.com.raulino.LanguageSchool.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.entities.Classroom;
import br.com.raulino.LanguageSchool.models.entities.Teacher;
import br.com.raulino.LanguageSchool.repositories.ClassroomRepository;
import br.com.raulino.LanguageSchool.repositories.TeacherRepository;
import br.com.raulino.LanguageSchool.utils.UtilsTest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@ExtendWith(MockitoExtension.class)
public class ClassroomServiceTest implements IServiceTest {
    
    @InjectMocks
    private ClassroomService classroomService;

    @Mock
    private ClassroomRepository classroomRepository;

    @Mock
    private TeacherRepository teacherRepository;

    private static Classroom cEntity = Converter.classroomDTOtoClassroomEntity(UtilsTest.CLASSROOM_DTO);

    private static Teacher tTeacher = Converter.teacherDTOtoTeacherEntity(UtilsTest.Teacher_DTO);

    @Override
    @Test
    public void test_findAll() {
        
        when(classroomRepository.findAll()).thenReturn(List.of());

        assertEquals(List.of(), classroomService.findAllClassrooms());

        when(classroomRepository.findAll()).thenReturn(List.of(cEntity));

        assertEquals(1, classroomService.findAllClassrooms().size());
    }

    @Override
    @Test
    public void test_findById() {
        
        when(classroomRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> classroomService.findClassroomById(1L));

        when(classroomRepository.findById(1L)).thenReturn(Optional.of(cEntity));

        assertEquals(cEntity.getClassCode() ,classroomService.findClassroomById(1L).getClassCode());
    }

    @Override
    @Test
    public void test_create() throws Exception {
        when(teacherRepository.existsById(1L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> classroomService.createClassroom(UtilsTest.CLASSROOM_DTO));

        when(teacherRepository.existsById(1L)).thenReturn(true);

        when(teacherRepository.findById(1L)).thenReturn(Optional.of(tTeacher));

        when(classroomRepository.save(cEntity)).thenReturn(cEntity);

        classroomService.createClassroom(UtilsTest.CLASSROOM_DTO);

        verify(classroomRepository, times(1)).save(cEntity);
    }

    @Override
    @Test
    @Transactional
    public void test_update() throws Exception {
        
        var opClassroom = Optional.of(cEntity);

        when(classroomRepository.findById(1L)).thenReturn(opClassroom);

        UtilsTest.CLASSROOM_DTO.setClassCode("CLASS-123");

        var updatedEntity = UpdateEntity.classroom(cEntity, UtilsTest.CLASSROOM_DTO);

        when(classroomRepository.save(updatedEntity)).thenReturn(updatedEntity);

        classroomService.updateClassroom(1L, UtilsTest.CLASSROOM_DTO);

        verify(classroomRepository, times(1)).save(updatedEntity);

        assertEquals("CLASS-123", classroomService.updateClassroom(1L, UtilsTest.CLASSROOM_DTO).getClassCode());
    }

    @Override
    @Test
    public void test_delete() {

        when(classroomRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> classroomService.deleteClassroom(1L));

        verify(classroomRepository, never()).delete(cEntity);

        when(classroomRepository.findById(1L)).thenReturn(Optional.of(cEntity));

        classroomService.deleteClassroom(1L);

        verify(classroomRepository, times(1)).delete(cEntity);
    }
}
