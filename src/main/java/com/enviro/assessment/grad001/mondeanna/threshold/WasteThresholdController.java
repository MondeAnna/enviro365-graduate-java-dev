package com.enviro.assessment.grad001.mondeanna.threshold;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/waste-thresholds" )
public class WasteThresholdController {

    private final WasteThresholdRepository repository;

    @Autowired
    public WasteThresholdController( WasteThresholdRepository repository ){
        this.repository = repository;
    }

    @GetMapping( path = "/" )
    public List<WasteThreshold> findAll() {
        return repository.findAll();
    }

    @GetMapping( path = "/{id}" )
    public Optional<WasteThreshold> findById( @Valid @PathVariable long id ){
        return repository.findById( id );
    }
}
