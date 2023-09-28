package br.com.raulino.LanguageSchool.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @NoArgsConstructor
final public class Teacher extends SchoolUser {

    @OneToMany(mappedBy = "teacher")
    private List<Classroom> classrooms;
}
