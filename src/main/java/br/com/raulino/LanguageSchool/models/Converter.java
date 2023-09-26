package br.com.raulino.LanguageSchool.models;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.dtos.TeacherDTO;
import br.com.raulino.LanguageSchool.models.entities.Address;
import br.com.raulino.LanguageSchool.models.entities.Classroom;
import br.com.raulino.LanguageSchool.models.entities.Student;
import br.com.raulino.LanguageSchool.models.entities.Teacher;

public class Converter {
    static public Student studentDTOtoStudentEntity(StudentDTO sDTO) {
        System.out.printf("From Converter: %s", sDTO.getStreet());
        Student st = new Student();
        st.setName(sDTO.getName());
        st.setLastName(sDTO.getLastName());
        st.setAddress(new Address(sDTO.getStreet(), sDTO.getCity(), sDTO.getCountry(), sDTO.getZipcode()));
        st.setBirthday(new Date(sDTO.getBirthday().getTime()));
        st.setActive(false);
        st.setCreatedAt(LocalDateTime.now());


        return st;
    }

    static public StudentDTO studentEntityToStudentDTO(Student s) {
        StudentDTO sDTO = new StudentDTO();
        sDTO.setId(s.getId());
        sDTO.setName(s.getName());
        sDTO.setLastName(s.getLastName());
        sDTO.setActive(s.getActive());
        sDTO.setStreet(s.getAddress().getStreet());
        sDTO.setCity(s.getAddress().getCity());
        sDTO.setCountry(s.getAddress().getCountry());
        sDTO.setZipcode(s.getAddress().getZipCode());
        sDTO.setBirthday(s.getBirthday());
        

        return sDTO;
    }

    static public Teacher teacherDTOtoTeacherEntity(TeacherDTO tDTO) {
        Teacher t = new Teacher();

        return t;
    }

    static public TeacherDTO teacherEntityToTeacherDTO(Teacher t) {
        TeacherDTO tDTO = new TeacherDTO();

        return tDTO;
    }

    static public Classroom classroomDTOtoClassroomEntity(ClassroomDTO cDTO) {
        Classroom classroom = new Classroom();

        return classroom;
    }

    static public ClassroomDTO classroomEntityToClassroomDTO(Classroom c) {
        ClassroomDTO cDTO = new ClassroomDTO();

        return cDTO;
    }
}
