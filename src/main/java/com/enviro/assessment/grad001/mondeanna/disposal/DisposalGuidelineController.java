package com.enviro.assessment.grad001.mondeanna.disposal;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/disposal-guidelines" )
public class DisposalGuidelineController {

    private final DisposalGuidelineServices services;

    @Autowired
    public DisposalGuidelineController( DisposalGuidelineServices services ){
        this.services = services;
    }

    @PostMapping( path = "/" )
    public ResponseEntity<DisposalGuideline> save( @Valid @RequestBody DisposalGuideline guideline ){
        DisposalGuideline saved = services.save( guideline );
        String path = getFinalRequestPath( this, saved );
        URI uri = URI.create( path );
        return ResponseEntity.created( uri ).build();
    }

    @GetMapping( path = "/" )
    public ResponseEntity<List<DisposalGuideline>> findAll() {
        return ResponseEntity.ok( services.findAll() );
    }

    @GetMapping( path = "/{id}" )
    public ResponseEntity<DisposalGuideline> findById( @Valid @PathVariable long id ){
        Optional<DisposalGuideline> optional = services.findById( id );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.badRequest().build() );
    }

    @PutMapping( path = "/{id}" )
    public ResponseEntity<DisposalGuideline> update( @Valid @PathVariable long id, @Valid @RequestBody DisposalGuideline guideline ){
        Optional<DisposalGuideline> optional = services.update( id, guideline );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.badRequest().build() );
    }

    @DeleteMapping( path = "/{id}" )
    public ResponseEntity<String> delete( @Valid @PathVariable long id ){
        if ( !services.delete( id ))
            return ResponseEntity.badRequest( ).body( "Invalid Argument" );
        return ResponseEntity.ok().body( String.format( "Disposal Guideline ID of %d deleted", id ));
    }

    public String getFinalRequestPath( DisposalGuidelineController controller, DisposalGuideline guideline ){
        String base = controller.getClass().getAnnotation( RequestMapping.class ).path()[0];
        return base + "/" + guideline.getId();
    }
}
