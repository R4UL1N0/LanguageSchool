package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.models.Converter;
import br.com.raulino.LanguageSchool.models.UpdateEntity;
import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.entities.Classroom;
import br.com.raulino.LanguageSchool.repositories.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Classroom c = Converter.classroomDTOtoClassroomEntity(cDTO);
        c.setCreatedAt(LocalDateTime.now());
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
