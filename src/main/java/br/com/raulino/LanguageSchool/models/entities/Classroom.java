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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((classCode == null) ? 0 : classCode.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Classroom other = (Classroom) obj;
        if (classCode == null) {
            if (other.classCode != null)
                return false;
        } else if (!classCode.equals(other.classCode))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (level != other.level)
            return false;
        if (language != other.language)
            return false;
        return true;
    }
}
