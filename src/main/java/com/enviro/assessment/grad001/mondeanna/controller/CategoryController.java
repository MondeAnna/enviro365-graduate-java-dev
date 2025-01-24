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

    @PostMapping( path = "/" )
    public Category save( @RequestBody Category category ){
        return repository.save( category );
    }

    @GetMapping( path = "/" )
    public List<Category> findAll() {
        return repository.findAll();
    }

    @GetMapping( path = "/{id}" )
    public Optional<Category> findById( @Valid @PathVariable long id ){
        return repository.findById( id );
    }

    @PutMapping( path = "/{id}" )
    public Category update( @Valid @PathVariable long id, @RequestBody Category category ){
        category.setId( id );
        return repository.save( category );
    }

    @DeleteMapping( path = "/{id}" )
    public String delete( @Valid @PathVariable long id ){
        if ( !repository.existsById( id ))
            return "Invalid argument";

        repository.deleteById( id );
        return String.format( "ID %d Category deleted", id );
    }
}
