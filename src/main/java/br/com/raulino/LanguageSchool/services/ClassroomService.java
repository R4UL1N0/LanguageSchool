package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.entities.Classroom;
import br.com.raulino.LanguageSchool.repositories.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<ClassroomDTO> findAllClassrooms() {

        return classroomRepository.findAll().stream().map(Converter::classroomEntityToClassroomDTO).toList();
    }

    public ClassroomDTO findClassroomById(Long id) {
        Classroom c = classroomRepository.findById(id).orElseThrow();

        return Converter.classroomEntityToClassroomDTO(c);
    }

    public ClassroomDTO createClassroom(ClassroomDTO cDTO) {

        Classroom c = classroomRepository.save(Converter.classroomDTOtoClassroomEntity(cDTO));
        return Converter.classroomEntityToClassroomDTO(c);

    }

    public void updateClassroom(ClassroomDTO cDTO) {

    }

    public ClassroomDTO deleteClassroom(Long id) {
        Classroom c = classroomRepository.findById(id).orElseThrow();

        classroomRepository.delete(c);

        return Converter.classroomEntityToClassroomDTO(c);
    }
}
