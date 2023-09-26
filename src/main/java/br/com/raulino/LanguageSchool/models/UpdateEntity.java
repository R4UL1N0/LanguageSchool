package br.com.raulino.LanguageSchool.models;

import java.sql.Date;
import java.time.LocalDateTime;

import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.dtos.TeacherDTO;
import br.com.raulino.LanguageSchool.models.entities.Address;
import br.com.raulino.LanguageSchool.models.entities.Classroom;
import br.com.raulino.LanguageSchool.models.entities.Student;
import br.com.raulino.LanguageSchool.models.entities.Teacher;

public class UpdateEntity {

    static public Student student(Student sEntity, StudentDTO sDTO) {
        if (sDTO.getName() != null) sEntity.setName(sDTO.getName());
        if (sDTO.getLastName() != null) sEntity.setLastName(sDTO.getLastName());
        if (sDTO.getBirthday() != null) sEntity.setBirthday(new Date(sDTO.getBirthday().getTime()));
        if (sDTO.getActive() != null) sEntity.setActive(sDTO.getActive());
        
        sEntity.setAddress(
            new Address(
                sDTO.getStreet() == null ? sEntity.getAddress().getStreet() : sDTO.getStreet(),
                sDTO.getCity() == null ? sEntity.getAddress().getCity() : sDTO.getCity(),
                sDTO.getCountry() == null ? sEntity.getAddress().getCountry() : sDTO.getCountry(),
                sDTO.getZipcode() == null ? sEntity.getAddress().getZipCode() : sDTO.getZipcode()
            )
        );

        sEntity.setUpdatedAt(LocalDateTime.now());

        return sEntity;
    }

    static public Teacher teacher(Teacher tEntity, TeacherDTO tDTO) {

        if (tDTO.getName() != null) tEntity.setName(tDTO.getName());
        if (tDTO.getLastName() != null) tEntity.setLastName(tDTO.getLastName());
        if (tDTO.getBirthday() != null) tEntity.setBirthday(new Date(tDTO.getBirthday().getTime()));
        if (tDTO.getActive() != null) tEntity.setActive(tDTO.getActive());
        
        tEntity.setAddress(
            new Address(
                tDTO.getStreet() == null ? tEntity.getAddress().getStreet() : tDTO.getStreet(),
                tDTO.getCity() == null ? tEntity.getAddress().getCity() : tDTO.getCity(),
                tDTO.getCountry() == null ? tEntity.getAddress().getCountry() : tDTO.getCountry(),
                tDTO.getZipcode() == null ? tEntity.getAddress().getZipCode() : tDTO.getZipcode()
            )
        );

        tEntity.setUpdatedAt(LocalDateTime.now());

        return tEntity;
    }
    
    static public Classroom classroom(Classroom cEntity, ClassroomDTO cDTO) {
        if (cDTO.getClassCode() != null ) cEntity.setClassCode(cDTO.getClassCode());
        if (cDTO.getLanguageLevel() != null) cEntity.setLevel(cDTO.getLanguageLevel());
        if (cDTO.getLanguageType() != null) cEntity.setLanguage(cDTO.getLanguageType());
        // if (cDTO.getTeacherId() != null) cEntity.setTeacher(null);
        if (cDTO.getStartDate() != null) cEntity.setStartDate(cDTO.getStartDate());
        if (cDTO.getEndDate() != null) cEntity.setEndDate(cDTO.getEndDate());

        cEntity.setUpdatedAt(LocalDateTime.now());

        return cEntity;
    }
}
