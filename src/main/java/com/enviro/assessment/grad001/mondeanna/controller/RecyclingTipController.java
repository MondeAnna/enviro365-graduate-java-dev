package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.model.RecyclingTip;
import com.enviro.assessment.grad001.mondeanna.service.RecyclingTipServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "/api/v1/recycling-tips" )
public class RecyclingTipController {

    private final RecyclingTipServices services;

    @Autowired
    public RecyclingTipController( RecyclingTipServices services ){
        this.services = services;
    }

    @PostMapping( path = "/" )
    public ResponseEntity<RecyclingTip> save(@Valid @RequestBody RecyclingTip tip ){
        RecyclingTip saved = services.save( tip );
        String path = getFinalRequestPath( this, saved );
        URI uri = URI.create( path );
        return ResponseEntity.created( uri ).build();
    }

    @GetMapping( path = "/" )
    public ResponseEntity<List<RecyclingTip>> findAll() {
        return ResponseEntity.ok( services.findAll() );
    }

    @GetMapping( path = "/{id}" )
    public ResponseEntity<RecyclingTip> findById( @Valid @PathVariable long id ){
        Optional<RecyclingTip> optional = services.findById( id );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.badRequest().build() );
    }

    @PutMapping( path = "/{id}" )
    public ResponseEntity<RecyclingTip> update( @Valid @PathVariable long id, @Valid @RequestBody RecyclingTip tip ){
        Optional<RecyclingTip> optional = services.update( id, tip );
        return optional.map( ResponseEntity::ok ).orElseGet( () -> ResponseEntity.badRequest().build() );
    }

    @DeleteMapping( path = "/{id}" )
    public ResponseEntity<String> delete( @Valid @PathVariable long id ){
        if ( !services.delete( id ))
            return ResponseEntity.badRequest( ).body( "Invalid Argument" );
        return ResponseEntity.ok().body( String.format( "Recycling Tip ID of %d deleted", id ));
    }

    public String getFinalRequestPath( RecyclingTipController controller, RecyclingTip tip ){
        String base = controller.getClass().getAnnotation( RequestMapping.class ).path()[0];
        return base + "/" + tip.getId();
    }
}
