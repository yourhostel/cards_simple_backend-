package com.tysser.cards.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class VisitDto {
    private Long id;
    private String firstName;
    private String surname;
    private String middleName;
    private String goal;
    private String description;
    private boolean statusVisit;
    private String doctorType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pressure; // Для CARDIOLOGIST

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastVisitDate; // Для DENTIST

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age; // Для THERAPIST

    public VisitDto() {
    }

    // Конструктор копирования
    public VisitDto(VisitDto source) {
        this.id = source.id;
        this.firstName = source.firstName;
        this.surname = source.surname;
        this.middleName = source.middleName;
        this.goal = source.goal;
        this.description = source.description;
        this.statusVisit = source.statusVisit;
        this.doctorType = source.doctorType;
        this.pressure = source.pressure;
        this.lastVisitDate = source.lastVisitDate;
        this.age = source.age;
    }
}
