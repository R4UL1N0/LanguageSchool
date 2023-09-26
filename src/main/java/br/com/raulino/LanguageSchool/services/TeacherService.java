package br.com.raulino.LanguageSchool.services;

import br.com.raulino.LanguageSchool.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
}
