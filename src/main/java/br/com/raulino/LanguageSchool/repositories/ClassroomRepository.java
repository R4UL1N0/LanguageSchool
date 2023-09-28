package br.com.raulino.LanguageSchool.repositories;

import br.com.raulino.LanguageSchool.models.entities.Classroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findClassroomsByTeacherId(Long id);
    Optional<Classroom> findClassroomByClassCode(String classCode);
}
