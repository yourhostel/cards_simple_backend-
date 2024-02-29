package com.tysser.cards.service;

import com.tysser.cards.dto.ResponseVisit;
import com.tysser.cards.dto.VisitDto;
import com.tysser.cards.exception.InvalidDoctorTypeException;
import com.tysser.cards.exception.ResourceNotFoundException;
import com.tysser.cards.model.Visit;
import com.tysser.cards.model.VisitCardiologist;
import com.tysser.cards.model.VisitDentist;
import com.tysser.cards.model.VisitTherapist;
import com.tysser.cards.repository.VisitRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.tysser.cards.model.Doctor.DENTIST;
import static com.tysser.cards.model.Doctor.CARDIOLOGIST;
import static com.tysser.cards.model.Doctor.THERAPIST;

@Service
@AllArgsConstructor
public class VisitService {

    @Autowired
    private final VisitRepository visitRepository;

    @Transactional
    public ResponseVisit createOrUpdateVisit(VisitDto visitDto, Optional<Long> id) {
        Visit visit = id.flatMap(visitRepository::findById).orElseGet(() -> {
            switch (visitDto.getDoctor()) {
                case "Кардіолог" -> {
                    return new VisitCardiologist();
                }
                case "Стоматолог" -> {
                    return new VisitDentist();
                }
                case "Терапевт" -> {
                    return new VisitTherapist();
                }
                default -> throw new InvalidDoctorTypeException("Invalid doctor type: " + visitDto.getDoctor());
            }
        });

        visit.setFirstName(visitDto.getFirstName());
        visit.setSurname(visitDto.getSurname());
        visit.setMiddleName(visitDto.getMiddleName());
        visit.setGoal(visitDto.getGoal());
        visit.setDescription(visitDto.getDescription());
        visit.setStatusVisit(visitDto.getStatusVisit());
        visit.setCategoryVisit(visitDto.getCategoryVisit());

        if (visit instanceof VisitCardiologist cardiologist) {
            cardiologist.setPressure(visitDto.getPressure());
            cardiologist.setCardiologistAge(visitDto.getCardiologistAge());
            cardiologist.setPreviousDiseas(visitDto.getPreviousDiseas());
            cardiologist.setBMI(visitDto.getBmi());
        } else if (visit instanceof VisitDentist dentist) {
            dentist.setVisitDentistDate(visitDto.getVisitDentistDate());
        } else if (visit instanceof VisitTherapist therapist) {
            therapist.setTherapistAge(visitDto.getTherapistAge());
        }

        return convertToResponseVisit(visitRepository.save(visit));
    }


    @Transactional(readOnly = true)
    public VisitDto findById(Long id) {
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visit not found"));
        return convertToDto(visit);
    }

    @Transactional
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<VisitDto> getAllVisits() {
        return visitRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public VisitDto convertToDto(Visit visit) {
        VisitDto dto = new VisitDto();

        dto.setId(visit.getId());
        dto.setFirstName(visit.getFirstName());
        dto.setSurname(visit.getSurname());
        dto.setMiddleName(visit.getMiddleName());
        dto.setGoal(visit.getGoal());
        dto.setDescription(visit.getDescription());
        dto.setStatusVisit(visit.getStatusVisit());
        dto.setCategoryVisit(visit.getCategoryVisit());

        if (visit instanceof VisitCardiologist cardiologist) {
            dto.setDoctor("Кардіолог");
            dto.setPressure(cardiologist.getPressure());
            dto.setCardiologistAge(cardiologist.getCardiologistAge());
            dto.setPreviousDiseas(cardiologist.getPreviousDiseas());
            dto.setBmi(cardiologist.getBMI());
        } else if (visit instanceof VisitDentist dentist) {
            dto.setDoctor("Стоматолог");
            dto.setVisitDentistDate(dentist.getVisitDentistDate());
        } else if (visit instanceof VisitTherapist therapist) {
            dto.setDoctor("Терапевт");
            dto.setTherapistAge(therapist.getTherapistAge());
        }

        return dto;
    }

    public ResponseVisit convertToResponseVisit(Visit visit) {
        ResponseVisit response = new ResponseVisit();
        response.setId(visit.getId());
        response.setFirstName(visit.getFirstName());
        response.setSurname(visit.getSurname());
        response.setMiddleName(visit.getMiddleName());
        response.setGoal(visit.getGoal());
        response.setDescription(visit.getDescription());
        response.setStatusVisit(visit.getStatusVisit());
        response.setCategoryVisit(visit.getCategoryVisit());

        if (visit instanceof VisitCardiologist cardiologist) {
            response.setDoctor(CARDIOLOGIST.getName());
            response.setPressure(cardiologist.getPressure());
            response.setCardiologistAge(cardiologist.getCardiologistAge());
            response.setPreviousDiseas(cardiologist.getPreviousDiseas());
            response.setBmi(cardiologist.getBMI());
        } else if (visit instanceof VisitDentist dentist) {
            response.setDoctor(DENTIST.getName());
            response.setVisitDentistDate(dentist.getVisitDentistDate());
        } else if (visit instanceof VisitTherapist therapist) {
            response.setDoctor(THERAPIST.getName());
            response.setTherapistAge(therapist.getTherapistAge());
        }

        return response;
    }

}
