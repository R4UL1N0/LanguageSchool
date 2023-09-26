package br.com.raulino.LanguageSchool.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity @NoArgsConstructor
public final class Student extends SchoolUser {

    @ManyToOne()
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}
