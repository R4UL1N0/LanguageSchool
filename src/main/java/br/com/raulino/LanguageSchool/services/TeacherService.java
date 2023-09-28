package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.dtos.TeacherDTO;
import br.com.raulino.LanguageSchool.models.entities.Teacher;
import br.com.raulino.LanguageSchool.repositories.TeacherRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Boolean doesTeacherExist(Long id) {
        return teacherRepository.existsById(id);
    }

    public List<TeacherDTO> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();

        return teachers.stream().map(Converter::teacherEntityToTeacherDTO).toList();
    }
    public TeacherDTO findTeacherById(Long id) {
        Teacher t = teacherRepository.findById(id).orElseThrow();

        return Converter.teacherEntityToTeacherDTO(t);
    }

    public TeacherDTO createTeacher(TeacherDTO tDTO) {
        Teacher teacher = Converter.teacherDTOtoTeacherEntity(tDTO);
        teacher.setCreatedAt(LocalDateTime.now());
        var t = teacherRepository.save(teacher);

        return Converter.teacherEntityToTeacherDTO(t);
    }

    public TeacherDTO updateTeacher(Long id, TeacherDTO tDTO) throws Exception {
        if (tDTO.getId() != null && tDTO.getId() != id) throw new Exception("Ids supplied don't match.");

        var oldTeacher = teacherRepository.findById(id).orElseThrow();

        var updatedTeacher = teacherRepository.save(UpdateEntity.teacher(oldTeacher, tDTO));

        return Converter.teacherEntityToTeacherDTO(updatedTeacher);

    }

    public TeacherDTO deleteTeacher(Long id) {
        Teacher t = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(t);

        return Converter.teacherEntityToTeacherDTO(t);
    }

}
