package br.com.raulino.LanguageSchool.models.dtos;

import java.time.LocalDate;

import br.com.raulino.LanguageSchool.models.enums.LanguageLevel;
import br.com.raulino.LanguageSchool.models.enums.LanguageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ClassroomDTO {
    private Long id;
    private String classCode;
    private Long teacherId;
    private LanguageType languageType;
    private LanguageLevel languageLevel;
    private LocalDate startDate;
    private LocalDate endDate;
}
