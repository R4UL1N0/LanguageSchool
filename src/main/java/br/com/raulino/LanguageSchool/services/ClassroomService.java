package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.entities.Classroom;
import br.com.raulino.LanguageSchool.repositories.ClassroomRepository;
import br.com.raulino.LanguageSchool.repositories.TeacherRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassroomService {

    private final TeacherRepository teacherRepository;

    private final ClassroomRepository classroomRepository;


    public ClassroomService(TeacherRepository teacherRepository, ClassroomRepository classroomRepository) {
        this.teacherRepository = teacherRepository;
        this.classroomRepository = classroomRepository;
    }

    public Boolean doesClassroomExist(Long id) {
        return classroomRepository.existsById(id);
    }

    public List<ClassroomDTO> findAllClassrooms() {

        return classroomRepository.findAll().stream().map(Converter::classroomEntityToClassroomDTO).toList();
    }

    public List<ClassroomDTO> findAllClassroomsByTeacherId(Long teacherId) {
        return classroomRepository.findClassroomsByTeacherId(teacherId).stream().map((c) -> Converter.classroomEntityToClassroomDTO(c)).toList();
    }

    public ClassroomDTO findClassroomById(Long id) {
        Classroom c = classroomRepository.findById(id).orElseThrow();

        return Converter.classroomEntityToClassroomDTO(c);
    }

    public ClassroomDTO findClassroomByClassCode(String classCode) throws Exception {
        var c = classroomRepository.findClassroomByClassCode(classCode).orElseThrow(() -> new Exception("No Classroom from classcode received."));
        return Converter.classroomEntityToClassroomDTO(c);
    }

    public ClassroomDTO createClassroom(ClassroomDTO cDTO) throws Exception {

        Classroom c = Converter.classroomDTOtoClassroomEntity(cDTO);
        c.setCreatedAt(LocalDateTime.now());
        if (cDTO.getTeacherId() != null && !teacherRepository.existsById(cDTO.getTeacherId())) throw new Exception("Teacher doesn't exist.");
        c.setTeacher(teacherRepository.findById(cDTO.getTeacherId()).get());

        var classroom = classroomRepository.save(c);
        return Converter.classroomEntityToClassroomDTO(classroom);

    }

    public ClassroomDTO updateClassroom(Long id, ClassroomDTO cDTO) throws Exception {
        if (cDTO.getId() != null && id != cDTO.getId()) throw new Exception("Ids supplied don't match.");

        Classroom c = classroomRepository.findById(id).orElseThrow();

        var updatedClassroom = classroomRepository.save(UpdateEntity.classroom(c, cDTO));

        return Converter.classroomEntityToClassroomDTO(updatedClassroom);

    }

    public ClassroomDTO deleteClassroom(Long id) {
        Classroom c = classroomRepository.findById(id).orElseThrow();

        classroomRepository.delete(c);

        return Converter.classroomEntityToClassroomDTO(c);
    }

}
