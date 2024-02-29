package com.tysser.cards.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VisitDto {
    private Long id;
    private String firstName;
    private String surname;
    private String middleName;
    private String goal;
    private String description;
    private String statusVisit;
    private String doctor;
    private String categoryVisit;

    // for CARDIOLOGIST
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pressure;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer cardiologistAge;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String previousDiseas;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BMI")
    private String bmi;

    // for DENTIST
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String visitDentistDate;

    // for THERAPIST
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer therapistAge;

    public VisitDto() {
    }

    // Copy constructor
    public VisitDto(VisitDto source) {
        this.id = source.id;
        this.firstName = source.firstName;
        this.surname = source.surname;
        this.middleName = source.middleName;
        this.goal = source.goal;
        this.description = source.description;
        this.statusVisit = source.statusVisit;
        this.doctor = source.doctor;
        this.categoryVisit = source.categoryVisit;
        this.pressure = source.pressure;
        this.cardiologistAge = source.cardiologistAge;
        this.previousDiseas = source.previousDiseas;
        this.bmi = source.bmi;
        this.visitDentistDate = source.visitDentistDate;
        this.therapistAge = source.therapistAge;
    }

}
