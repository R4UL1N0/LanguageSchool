package br.com.raulino.LanguageSchool.models.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public final class StudentDTO {
    private Long id;
    private String name;
    private String lastName;
    private Date birthday;
    private Boolean active;
    private String street;
    private String city;
    private String country;
    private String zipcode;
    private Long classroomId;
}
