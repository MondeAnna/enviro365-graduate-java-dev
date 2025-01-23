package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.model.Waste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping( path = "/api/v1/wastes" )
public class WasteController {

    private final Set<Waste> repository;

    @Autowired
    public WasteController( Set<Waste> repository ) {
        this.repository = repository;
    }
}
