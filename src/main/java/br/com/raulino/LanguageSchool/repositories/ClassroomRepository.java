package br.com.raulino.LanguageSchool.repositories;

import br.com.raulino.LanguageSchool.models.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
