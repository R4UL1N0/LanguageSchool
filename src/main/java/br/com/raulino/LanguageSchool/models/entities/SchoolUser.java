package br.com.raulino.LanguageSchool.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@MappedSuperclass
@Data
@RequiredArgsConstructor
sealed public class SchoolUser permits Student, Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "last_name", length = 250, nullable = false)
    private String lastName;
    @Column(name = "birthdate", nullable = false)
    private Date dateOfBirth;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(insertable = false, updatable = false)),
            @AttributeOverride(name = "city", column = @Column(insertable = false, updatable = false)),
            @AttributeOverride(name = "country", column = @Column(insertable = false, updatable = false)),
            @AttributeOverride(name = "zipcode", column = @Column(insertable = false, updatable = false))
    })
    private Address address;
    @Column(name = "active", nullable = false)
    private Boolean active;
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
