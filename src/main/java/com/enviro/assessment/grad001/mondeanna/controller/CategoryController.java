package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.model.Category;
import com.enviro.assessment.grad001.mondeanna.repository.CategoryRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/categories" )
public class CategoryController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryController( CategoryRepository repository ){
        this.repository = repository;
    }

    @GetMapping( path = "/" )
    public List<Category> findAll() {
        return repository.findAll();
    }

    @GetMapping( path = "/{id}" )
    public Optional<Category> findById( @Valid @PathVariable long id ){
        return repository.findById( id );
    }

    @PostMapping( path = "/" )
    public Category save( @RequestBody Category category ){
        return repository.save( category );
    }
}
