package br.com.raulino.LanguageSchool.models.entities;

import br.com.raulino.LanguageSchool.models.enums.LanguageLevel;
import br.com.raulino.LanguageSchool.models.enums.LanguageType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity @NoArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "class_code", nullable = false, length = 10)
    private String classCode;
    @Enumerated(EnumType.STRING)
    private LanguageLevel level;
    @Enumerated(EnumType.STRING)
    private LanguageType language;
    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy= "classroom")
    private List<Student> students;
}
