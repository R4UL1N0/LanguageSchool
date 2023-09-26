package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.dtos.TeacherDTO;
import br.com.raulino.LanguageSchool.models.entities.Teacher;
import br.com.raulino.LanguageSchool.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDTO> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();

        // if (teachers.isEmpty()) return List.of();

        return teachers.stream().map(Converter::teacherEntityToTeacherDTO).toList();
    }
    public TeacherDTO findTeacherById(Long id) {
        Teacher t = teacherRepository.findById(id).orElseThrow();

        return Converter.teacherEntityToTeacherDTO(t);
    }

    public TeacherDTO createTeacher(TeacherDTO tDTO) {
        Teacher teacher = teacherRepository.save(Converter.teacherDTOtoTeacherEntity(tDTO));

        return Converter.teacherEntityToTeacherDTO(teacher);
    }

    public void updateTeacher(TeacherDTO tDTO) {

    }

    public TeacherDTO deleteTeacher(Long id) {
        Teacher t = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(t);

        return Converter.teacherEntityToTeacherDTO(t);
    }

}
