package com.enviro.assessment.grad001.mondeanna.waste;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ResponseStatus( HttpStatus.CREATED )
    @PostMapping( path = "/" )
    public Category save( @Valid @RequestBody Category category ){
        return repository.save( category );
    }

    @GetMapping( path = "/" )
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok( repository.findAll() );
    }

    @GetMapping( path = "/{id}" )
    public Optional<Category> findById( @Valid @PathVariable long id ){
        return repository.findById( id );
    }

    @PutMapping( path = "/{id}" )
    public Category update( @Valid @PathVariable long id, @Valid @RequestBody Category category ){
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
