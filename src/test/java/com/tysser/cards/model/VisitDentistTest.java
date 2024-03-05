package com.tysser.cards.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitDentistTest {

    private VisitDentist visitDentist;

    @BeforeEach
    void setUp() {
        visitDentist = new VisitDentist();
        visitDentist.setFirstName("Jane");
        visitDentist.setSurname("Smith");
        visitDentist.setMiddleName("B.");
        visitDentist.setGoal("Tooth repair");
        visitDentist.setDescription("Chipped tooth repair");
        visitDentist.setVisitDentistDate("2023-03-15");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Jane", visitDentist.getFirstName());
        assertEquals("Smith", visitDentist.getSurname());
        assertEquals("B.", visitDentist.getMiddleName());
        assertEquals("Tooth repair", visitDentist.getGoal());
        assertEquals("Chipped tooth repair", visitDentist.getDescription());
        assertEquals("2023-03-15", visitDentist.getVisitDentistDate());
    }

}
