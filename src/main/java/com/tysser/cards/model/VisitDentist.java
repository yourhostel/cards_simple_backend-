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

    @Column(name = "visit_dentist_date")
    private String visitDentistDate;

}