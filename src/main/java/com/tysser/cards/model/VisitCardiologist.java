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

}