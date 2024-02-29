package com.tysser.cards.model;

public enum Doctor {
    CARDIOLOGIST("Кардіолог"),
    THERAPIST("Терапевт"),
    DENTIST("Стоматолог");

    private final String name;

    Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
