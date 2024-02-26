package com.tysser.cards.controller;

import com.tysser.cards.dto.VisitDto;
import com.tysser.cards.model.Visit;
import com.tysser.cards.service.VisitService;
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

import java.util.Optional;


@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public ResponseEntity<Visit> createVisit(@RequestBody VisitDto visitDto) {
        Visit savedVisit = visitService
                .createOrUpdateVisit(visitDto, Optional.empty());
        return ResponseEntity.ok(savedVisit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visit> getVisit(@PathVariable Long id) {
        Visit visit = visitService.findById(id);
        return ResponseEntity.ok(visit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visit> updateVisit(@PathVariable Long id,
                                             @RequestBody VisitDto visitDto) {
        Visit updatedVisit = visitService
                .createOrUpdateVisit(visitDto, Optional.of(id));
        return ResponseEntity.ok(updatedVisit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
        return ResponseEntity.ok().build();
    }
}
