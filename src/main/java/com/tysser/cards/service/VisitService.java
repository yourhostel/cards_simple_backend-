package com.tysser.cards.service;

import com.tysser.cards.dto.VisitDto;
import com.tysser.cards.model.Visit;
import com.tysser.cards.model.VisitCardiologist;
import com.tysser.cards.model.VisitDentist;
import com.tysser.cards.model.VisitTherapist;
import com.tysser.cards.repository.VisitRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Transactional
    public Visit createOrUpdateVisit(VisitDto visitDto, Optional<Long> id) {
        Visit visit = id.flatMap(visitRepository::findById).orElseGet(() -> {
            return switch (visitDto.getDoctorType()) {
                case "CARDIOLOGIST" -> new VisitCardiologist();
                case "DENTIST" -> new VisitDentist();
                case "THERAPIST" -> new VisitTherapist();
                default -> throw new IllegalArgumentException("Invalid doctor type");
            };
        });

        if (visit instanceof VisitCardiologist && "CARDIOLOGIST".equals(visitDto.getDoctorType())) {
            ((VisitCardiologist) visit).setPressure(visitDto.getPressure());
        } else if (visit instanceof VisitDentist && "DENTIST".equals(visitDto.getDoctorType())) {
            ((VisitDentist) visit).setLastVisitDate(visitDto.getLastVisitDate());
        } else if (visit instanceof VisitTherapist && "THERAPIST".equals(visitDto.getDoctorType())) {
            ((VisitTherapist) visit).setAge(visitDto.getAge());
        }

        visit.setFirstName(visitDto.getFirstName());
        visit.setSurname(visitDto.getSurname());
        visit.setMiddleName(visitDto.getMiddleName());
        visit.setGoal(visitDto.getGoal());
        visit.setDescription(visitDto.getDescription());
        visit.setStatusVisit(visitDto.isStatusVisit());

        return visitRepository.save(visit);
    }

    @Transactional(readOnly = true)
    public Visit findById(Long id) {
        return visitRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found"));
    }

    @Transactional
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
