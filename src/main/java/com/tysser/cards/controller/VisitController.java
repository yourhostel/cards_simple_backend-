package com.tysser.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tysser.cards.dto.ResponseVisit;
import com.tysser.cards.dto.VisitDto;
import com.tysser.cards.model.Visit;
import com.tysser.cards.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private final VisitService visitService;

    @PostMapping
    public ResponseEntity<ResponseVisit> createVisit(@RequestBody VisitDto visitDto) {
        System.out.println(visitDto);
        ResponseVisit savedVisit = visitService
                .createOrUpdateVisit(visitDto, Optional.empty());
        return ResponseEntity.ok(savedVisit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDto> getVisit(@PathVariable Long id) {
        VisitDto visit = visitService.findById(id);
        return ResponseEntity.ok(visit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseVisit> updateVisit(@PathVariable Long id,
                                             @RequestBody VisitDto visitDto) {
        ResponseVisit updatedVisit = visitService
                .createOrUpdateVisit(visitDto, Optional.of(id));
        return ResponseEntity.ok(updatedVisit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<VisitDto>> getAllVisits() {
        List<VisitDto> visits = visitService.getAllVisits();
        return ResponseEntity.ok(visits);
    }

}
