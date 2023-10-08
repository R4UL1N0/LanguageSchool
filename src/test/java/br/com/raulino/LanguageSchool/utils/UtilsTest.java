package br.com.raulino.LanguageSchool.utils;

import java.sql.Date;
import java.time.LocalDate;

import br.com.raulino.LanguageSchool.models.dtos.ClassroomDTO;
import br.com.raulino.LanguageSchool.models.dtos.StudentDTO;
import br.com.raulino.LanguageSchool.models.dtos.TeacherDTO;
import br.com.raulino.LanguageSchool.models.entities.Address;
import br.com.raulino.LanguageSchool.models.enums.LanguageLevel;
import br.com.raulino.LanguageSchool.models.enums.LanguageType;

public class UtilsTest {

    public static Address ADDRESS = new Address("Rua Tal, 99", "Blumenau", "Brasil", "890000-00" );

    public static StudentDTO STUDENT_DTO = StudentDTO.builder()
        .id(1L)
        .name("James")
        .lastName("Cameron")
        .birthday(Date.valueOf(LocalDate.now().minusYears(15)))
        .street("Rua Tal")
        .city("Blumenau")
        .country("Brasil")
        .zipcode("89000-000")
        .active(true)
        .classroomId(1L)
        .build();

    public static TeacherDTO Teacher_DTO = TeacherDTO.builder()
        .id(1L)
        .name("James")
        .lastName("Cameron")
        .birthday(Date.valueOf(LocalDate.now().minusYears(15)))
        .street("Rua Tal")
        .city("Blumenau")
        .country("Brasil")
        .zipcode("89000-000")
        .active(true)
        .build();

    public static ClassroomDTO CLASSROOM_DTO = ClassroomDTO.builder()
        .id(1L)
        .teacherId(1L)
        .classCode("CLA123")
        .startDate(LocalDate.now())
        .endDate(LocalDate.now().plusMonths(6))
        .languageLevel(LanguageLevel.A1)
        .languageType(LanguageType.ENGLISH)
        .build();
}
