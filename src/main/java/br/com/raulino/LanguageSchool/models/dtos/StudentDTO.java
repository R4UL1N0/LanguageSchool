package br.com.raulino.LanguageSchool.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public final class StudentDTO extends SchoolUserDTO {
    private Long classroomId;
}
