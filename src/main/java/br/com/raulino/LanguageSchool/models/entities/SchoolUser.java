package br.com.raulino.LanguageSchool.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
@MappedSuperclass
@Getter @Setter 
abstract public class SchoolUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    @Column(name = "birthday", nullable = false)
    private Date birthday;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(updatable = false)),
            @AttributeOverride(name = "city", column = @Column(updatable = false)),
            @AttributeOverride(name = "zipcode", column = @Column(updatable = false)),
            @AttributeOverride(name = "country", column = @Column(updatable = false)),
            
    })
    private Address address;
    @Column(name = "active", nullable = false)
    private Boolean active;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;


}
