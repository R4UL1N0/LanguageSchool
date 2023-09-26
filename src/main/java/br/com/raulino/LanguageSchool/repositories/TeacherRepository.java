package br.com.raulino.LanguageSchool.repositories;

import br.com.raulino.LanguageSchool.models.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
