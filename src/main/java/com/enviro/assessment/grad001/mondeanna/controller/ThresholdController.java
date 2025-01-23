package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.model.Threshold;
import com.enviro.assessment.grad001.mondeanna.repository.ThresholdRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/thresholds" )
public class ThresholdController {

    private final ThresholdRepository repository;

    @Autowired
    public ThresholdController(ThresholdRepository repository ){
        this.repository = repository;
    }

    @GetMapping( path = "/" )
    public List<Threshold> findAll() {
        return repository.findAll();
    }

    @GetMapping( path = "/{id}" )
    public Optional<Threshold> findById( @Valid @PathVariable long id ){
        return repository.findById( id );
    }
}
