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

    private final CategoryRepository repository;

    @Autowired
    public CategoryController( CategoryRepository repository ){
        this.repository = repository;
    }

    @PostMapping( path = "/" )
    public ResponseEntity<Category> save( @Valid @RequestBody Category category ){
        Category saved = repository.save( category );
        String path = getFinalRequestPath( this, saved );
        URI uri = URI.create( path );
        return ResponseEntity.created( uri ).build();
    }

    @GetMapping( path = "/" )
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok( repository.findAll() );
    }

    @GetMapping( path = "/{id}" )
    public ResponseEntity<Category> findById( @Valid @PathVariable long id ){
        Optional<Category> optional = repository.findById( id );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @PutMapping( path = "/{id}" )
    public ResponseEntity<Category> update( @Valid @PathVariable long id, @Valid @RequestBody Category category ){
        if ( !repository.existsById( id ))
            return ResponseEntity.badRequest().build();
        category.setId( id );
        return ResponseEntity.ok( Optional.of( repository.save( category )).get() );
    }

    @DeleteMapping( path = "/{id}" )
    public ResponseEntity<String> delete( @Valid @PathVariable long id ){
        if ( !repository.existsById( id ))
            return ResponseEntity.badRequest( ).body( "Invalid Argument" );

        repository.deleteById( id );
        return ResponseEntity.ok().body( String.format( "Category ID of %d deleted", id ));
    }

    public String getFinalRequestPath( CategoryController controller, Category category ){
        String base = controller.getClass().getAnnotation( RequestMapping.class ).path()[0];
        return base + "/" + category.getId();
    }
}
