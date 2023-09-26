package br.com.raulino.LanguageSchool.models;

import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.entities.Student;

public class Converter {
    static public Student studentDTOtoStudentEntity(StudentDTO s) {
        Student st = new Student();
        return new Student();
    }

    static public void studentEntityToStudentDTO() {

    }
}
