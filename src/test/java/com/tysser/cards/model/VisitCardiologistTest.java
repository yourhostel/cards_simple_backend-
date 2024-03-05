package com.tysser.cards.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitCardiologistTest {

    private VisitCardiologist visitCardiologist;

    @BeforeEach
    void setUp() {
        visitCardiologist = new VisitCardiologist();
        visitCardiologist.setFirstName("John");
        visitCardiologist.setSurname("Doe");
        visitCardiologist.setMiddleName("A.");
        visitCardiologist.setGoal("Checkup");
        visitCardiologist.setDescription("Routine yearly checkup");
        visitCardiologist.setPressure("120/80");
        visitCardiologist.setCardiologistAge(45);
        visitCardiologist.setPreviousDiseas("None");
        visitCardiologist.setBMI("22.5");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("John", visitCardiologist.getFirstName());
        assertEquals("Doe", visitCardiologist.getSurname());
        assertEquals("A.", visitCardiologist.getMiddleName());
        assertEquals("Checkup", visitCardiologist.getGoal());
        assertEquals("Routine yearly checkup", visitCardiologist.getDescription());
        assertEquals("120/80", visitCardiologist.getPressure());
        assertEquals(45, visitCardiologist.getCardiologistAge());
        assertEquals("None", visitCardiologist.getPreviousDiseas());
        assertEquals("22.5", visitCardiologist.getBMI());
    }

}
