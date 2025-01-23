package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.model.Waste;
import com.enviro.assessment.grad001.mondeanna.repository.WasteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/wastes" )
public class WasteController {

    private final WasteRepository repository;

    @Autowired
    public WasteController( WasteRepository repository ){
        this.repository = repository;
    }

    @GetMapping( path = "/" )
    public List<Waste> findAll() {
        return repository.findAll();
    }

    @GetMapping( path = "/{formula}" )
    public Optional<Waste> findById(@PathVariable String formula ){
        return repository.findById( formula );
    }
}
