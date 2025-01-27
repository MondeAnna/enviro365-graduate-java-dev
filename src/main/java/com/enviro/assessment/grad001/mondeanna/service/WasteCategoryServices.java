package com.enviro.assessment.grad001.mondeanna.service;

import com.enviro.assessment.grad001.mondeanna.model.WasteCategory;
import com.enviro.assessment.grad001.mondeanna.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryServices {

    private final WasteCategoryRepository repository;

    @Autowired
    public WasteCategoryServices( WasteCategoryRepository repository ){
        this.repository = repository;
    }

    public WasteCategory save(WasteCategory category ){
        return repository.save( category );
    }

    public List<WasteCategory> findAll(){
        return repository.findAll();
    }

    public Optional<WasteCategory> findById( long id ){
        return repository.findById( id );
    }

    public Optional<WasteCategory> update( long id, WasteCategory category ){
        if ( !repository.existsById( id ))
            return Optional.empty();
        category.setId( id );
        return Optional.of( repository.save( category ));
    }

    public boolean delete( long id ){
        if ( !repository.existsById( id ))
            return false;
        repository.deleteById( id );
        return true;
    }
}
