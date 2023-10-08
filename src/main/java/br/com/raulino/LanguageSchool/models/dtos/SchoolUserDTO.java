package br.com.raulino.LanguageSchool.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
abstract class SchoolUserDTO {
    private Long id;
    private String name;
    private String lastName;
    private Date birthday;
    private Boolean active;
    private String street;
    private String city;
    private String country;
    private String zipcode;
}
