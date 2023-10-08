package br.com.raulino.LanguageSchool.models;
import java.sql.Date;

import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.dtos.TeacherDTO;
import br.com.raulino.LanguageSchool.models.entities.Address;
import br.com.raulino.LanguageSchool.models.entities.Classroom;
import br.com.raulino.LanguageSchool.models.entities.Student;
import br.com.raulino.LanguageSchool.models.entities.Teacher;

public class Converter {
    static public Student studentDTOtoStudentEntity(StudentDTO sDTO) {
        Student sEntity = new Student();
        sEntity.setName(sDTO.getName());
        sEntity.setLastName(sDTO.getLastName());
        sEntity.setAddress(new Address(sDTO.getStreet(), sDTO.getCity(), sDTO.getCountry(), sDTO.getZipcode()));
        sEntity.setBirthday(new Date(sDTO.getBirthday().getTime()));
        sEntity.setActive(false);

        return sEntity;
    }

    static public StudentDTO studentEntityToStudentDTO(Student sEntity) {
        StudentDTO sDTO = new StudentDTO();
        sDTO.setId(sEntity.getId());
        sDTO.setName(sEntity.getName());
        sDTO.setLastName(sEntity.getLastName());
        sDTO.setActive(sEntity.getActive());
        sDTO.setStreet(sEntity.getAddress().getStreet());
        sDTO.setCity(sEntity.getAddress().getCity());
        sDTO.setCountry(sEntity.getAddress().getCountry());
        sDTO.setZipcode(sEntity.getAddress().getZipCode());
        sDTO.setBirthday(sEntity.getBirthday());
        if (sEntity.getClassroom() != null) sDTO.setClassroomId(sEntity.getClassroom().getId());
        
        

        return sDTO;
    }

    static public Teacher teacherDTOtoTeacherEntity(TeacherDTO tDTO) {
        Teacher tEntity = new Teacher();
        tEntity.setName(tDTO.getName());
        tEntity.setLastName(tDTO.getLastName());
        tEntity.setAddress(new Address(tDTO.getStreet(), tDTO.getCity(), tDTO.getCountry(), tDTO.getZipcode()));
        tEntity.setBirthday(new Date(tDTO.getBirthday().getTime()));
        tEntity.setActive(false);

        return tEntity;
    }

    static public TeacherDTO teacherEntityToTeacherDTO(Teacher tEntity) {
        TeacherDTO tDTO = new TeacherDTO();
        tDTO.setId(tEntity.getId());
        tDTO.setName(tEntity.getName());
        tDTO.setLastName(tEntity.getLastName());
        tDTO.setActive(tEntity.getActive());
        tDTO.setStreet(tEntity.getAddress().getStreet());
        tDTO.setCity(tEntity.getAddress().getCity());
        tDTO.setCountry(tEntity.getAddress().getCountry());
        tDTO.setZipcode(tEntity.getAddress().getZipCode());
        tDTO.setBirthday(tEntity.getBirthday());
        

        return tDTO;
    }

    static public Classroom classroomDTOtoClassroomEntity(ClassroomDTO cDTO) {
        Classroom cEntity = new Classroom();
        if (cDTO.getId() != null) cEntity.setId(cDTO.getId());
        cEntity.setClassCode(cDTO.getClassCode());
        cEntity.setStartDate(cDTO.getStartDate());
        cEntity.setEndDate(cDTO.getEndDate());
        cEntity.setLanguage(cDTO.getLanguageType());
        cEntity.setLevel(cDTO.getLanguageLevel());

        return cEntity;
    }

    static public ClassroomDTO classroomEntityToClassroomDTO(Classroom cEntity) {
        ClassroomDTO cDTO = new ClassroomDTO();
        cDTO.setId(cEntity.getId());
        cDTO.setClassCode(cEntity.getClassCode());
        cDTO.setStartDate(cEntity.getStartDate());
        cDTO.setEndDate(cEntity.getEndDate());
        cDTO.setLanguageType(cEntity.getLanguage());
        cDTO.setLanguageLevel(cEntity.getLevel());
        if (cEntity.getTeacher() != null) cDTO.setTeacherId(cEntity.getTeacher().getId());
        

        return cDTO;
    }
}
