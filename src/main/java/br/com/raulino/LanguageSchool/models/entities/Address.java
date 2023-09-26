package br.com.raulino.LanguageSchool.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable @Getter @AllArgsConstructor @NoArgsConstructor
public class Address {
    @Column(name = "street", length = 200, nullable = true)
    private String street;
    @Column(name = "city", length = 100, nullable = true)
    private String city;
    @Column(name = "street", length = 100, nullable = true)
    private String country;
    @Column(name = "zipcode", length = 20, nullable = true)
    private String zipCode;
}
