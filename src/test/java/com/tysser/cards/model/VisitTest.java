package com.tysser.cards.model;

import com.tysser.cards.repository.VisitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class VisitTest {

    @Autowired
    private VisitRepository visitRepository;

    @Test
    public void whenVisitIsCreated_thenAuditingFieldsArePopulated() {
        VisitCardiologist visitCardiologist = new VisitCardiologist();
        visitCardiologist.setFirstName("John");
        visitCardiologist.setSurname("Doe");
        visitCardiologist.setMiddleName("A.");
        visitCardiologist.setGoal("Checkup");
        visitCardiologist.setDescription("Routine yearly checkup");
        visitCardiologist.setPressure("120/80");
        visitCardiologist.setCardiologistAge(45);
        visitCardiologist.setPreviousDiseas("None");
        visitCardiologist.setBMI("22.5");

        visitCardiologist = visitRepository.save(visitCardiologist);

        Optional<Visit> foundVisit = visitRepository.findById(visitCardiologist.getId());

        assertTrue(foundVisit.isPresent());
        assertNotNull(foundVisit.get().getCreatedDate());
        assertNotNull(foundVisit.get().getLastModifiedDate());

        // Перевіряємо, що дати створення та останньої зміни лежать у розумних межах часу.
        assertTrue(foundVisit.get().getCreatedDate().isBefore(LocalDateTime.now().plusMinutes(1)));
        assertTrue(foundVisit.get().getLastModifiedDate().isBefore(LocalDateTime.now().plusMinutes(1)));
    }

}
