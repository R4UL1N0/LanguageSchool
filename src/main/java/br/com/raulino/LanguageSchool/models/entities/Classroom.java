package br.com.raulino.LanguageSchool.models.entities;

import br.com.raulino.LanguageSchool.models.enums.LanguageLevel;
import br.com.raulino.LanguageSchool.models.enums.LanguageType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter @Setter @RequiredArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "class_code", nullable = false, length = 10)
    private String classCode;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "class_level")
    private LanguageLevel level;
    @Enumerated(EnumType.STRING)
    @Column(name = "class_lang")
    private LanguageType language;
    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy= "classroom")
    private List<Student> students;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
