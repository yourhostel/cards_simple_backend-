package com.tysser.cards.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("DENTIST")
@EqualsAndHashCode(callSuper = true)
public class VisitDentist extends Visit {

    @Column(name = "last_visit_date")
    private String lastVisitDate;

}