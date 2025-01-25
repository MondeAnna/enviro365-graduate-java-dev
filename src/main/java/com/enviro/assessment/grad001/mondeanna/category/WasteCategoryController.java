package com.enviro.assessment.grad001.mondeanna.category;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/waste-categories" )
public class WasteCategoryController {

    private final WasteCategoryServices services;

    @Autowired
    public WasteCategoryController(WasteCategoryServices services ){
        this.services = services;
    }

    @PostMapping( path = "/" )
    public ResponseEntity<WasteCategory> save( @Valid @RequestBody WasteCategory category ){
        WasteCategory saved = services.save( category );
        String path = getFinalRequestPath( this, saved );
        URI uri = URI.create( path );
        return ResponseEntity.created( uri ).build();
    }

    @GetMapping( path = "/" )
    public ResponseEntity<List<WasteCategory>> findAll() {
        return ResponseEntity.ok( services.findAll() );
    }

    @GetMapping( path = "/{id}" )
    public ResponseEntity<WasteCategory> findById( @Valid @PathVariable long id ){
        Optional<WasteCategory> optional = services.findById( id );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @PutMapping( path = "/{id}" )
    public ResponseEntity<WasteCategory> update( @Valid @PathVariable long id, @Valid @RequestBody WasteCategory category ){
        Optional<WasteCategory> optional = services.update( id, category );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.badRequest().build() );
    }

    @DeleteMapping( path = "/{id}" )
    public ResponseEntity<String> delete( @Valid @PathVariable long id ){
        if ( !services.delete( id ))
            return ResponseEntity.badRequest( ).body( "Invalid Argument" );
        return ResponseEntity.ok().body( String.format( "Waste Category ID of %d deleted", id ));
    }

    public String getFinalRequestPath(WasteCategoryController controller, WasteCategory category ){
        String base = controller.getClass().getAnnotation( RequestMapping.class ).path()[0];
        return base + "/" + category.getId();
    }
}
