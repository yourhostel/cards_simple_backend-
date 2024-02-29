package com.tysser.cards.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@DiscriminatorValue("CARDIOLOGIST")
@EqualsAndHashCode(callSuper = true)
public class VisitCardiologist extends Visit {

    @Column(name = "pressure")
    private String pressure;

    @Column(name = "cardiologist_age")
    private int cardiologistAge;

    @Column(name = "previous_diseas")
    private String previousDiseas;

    @Column(name = "BMI")
    private String BMI;
}