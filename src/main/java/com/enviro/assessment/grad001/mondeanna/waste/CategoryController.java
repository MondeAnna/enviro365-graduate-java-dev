package com.enviro.assessment.grad001.mondeanna.waste;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/categories" )
public class CategoryController {

    private final CategoryServices services;

    @Autowired
    public CategoryController( CategoryServices services ){
        this.services = services;
    }

    @PostMapping( path = "/" )
    public ResponseEntity<Category> save( @Valid @RequestBody Category category ){
        Category saved = services.save( category );
        String path = getFinalRequestPath( this, saved );
        URI uri = URI.create( path );
        return ResponseEntity.created( uri ).build();
    }

    @GetMapping( path = "/" )
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok( services.findAll() );
    }

    @GetMapping( path = "/{id}" )
    public ResponseEntity<Category> findById( @Valid @PathVariable long id ){
        Optional<Category> optional = services.findById( id );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @PutMapping( path = "/{id}" )
    public ResponseEntity<Category> update( @Valid @PathVariable long id, @Valid @RequestBody Category category ){
        Optional<Category> optional = services.update( id, category );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.badRequest().build() );
    }

    @DeleteMapping( path = "/{id}" )
    public ResponseEntity<String> delete( @Valid @PathVariable long id ){
        if ( !services.delete( id ))
            return ResponseEntity.badRequest( ).body( "Invalid Argument" );
        return ResponseEntity.ok().body( String.format( "Category ID of %d deleted", id ));
    }

    public String getFinalRequestPath( CategoryController controller, Category category ){
        String base = controller.getClass().getAnnotation( RequestMapping.class ).path()[0];
        return base + "/" + category.getId();
    }
}
