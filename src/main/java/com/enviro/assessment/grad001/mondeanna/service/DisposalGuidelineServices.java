package com.enviro.assessment.grad001.mondeanna.service;

import com.enviro.assessment.grad001.mondeanna.model.DisposalGuideline;
import com.enviro.assessment.grad001.mondeanna.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineServices {

    private final DisposalGuidelineRepository repository;

    @Autowired
    public DisposalGuidelineServices( DisposalGuidelineRepository repository ){
        this.repository = repository;
    }

    public DisposalGuideline save(DisposalGuideline guideline ){
        return repository.save( guideline );
    }

    public List<DisposalGuideline> findAll(){
        return repository.findAll();
    }

    public Optional<DisposalGuideline> findById( long id ){
        return repository.findById( id );
    }

    public Optional<DisposalGuideline> update( long id, DisposalGuideline guideline ){
        if ( !repository.existsById( id ))
            return Optional.empty();
        guideline.setId( id );
        return Optional.of( repository.save( guideline ));
    }

    public boolean delete( long id ){
        if ( !repository.existsById( id ))
            return false;
        repository.deleteById( id );
        return true;
    }
}
