package br.com.raulino.LanguageSchool.repositories;

import br.com.raulino.LanguageSchool.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
