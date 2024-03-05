package com.tysser.cards.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitTherapistTest {

    private VisitTherapist visitTherapist;

    @BeforeEach
    void setUp() {
        visitTherapist = new VisitTherapist();
        visitTherapist.setFirstName("Emily");
        visitTherapist.setSurname("Watson");
        visitTherapist.setMiddleName("C.");
        visitTherapist.setGoal("General check-up");
        visitTherapist.setDescription("Annual general health check-up");
        visitTherapist.setTherapistAge(40);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Emily", visitTherapist.getFirstName());
        assertEquals("Watson", visitTherapist.getSurname());
        assertEquals("C.", visitTherapist.getMiddleName());
        assertEquals("General check-up", visitTherapist.getGoal());
        assertEquals("Annual general health check-up", visitTherapist.getDescription());
        assertEquals(40, visitTherapist.getTherapistAge());
    }
}
