package com.tysser.cards.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@DiscriminatorValue("THERAPIST")
@EqualsAndHashCode(callSuper = true)
public class VisitTherapist extends Visit {

    @Column(name = "age")
    private int age;

}
