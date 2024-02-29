package com.tysser.cards.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "doctor", discriminatorType = DiscriminatorType.STRING)
public abstract class Visit extends AbstractFields {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "goal")
    private String goal;

    @Column(name = "description")
    private String description;

    @Column(name = "status_visit")
    private String statusVisit;

    @Column(name = "category_visit")
    private String categoryVisit;

}
