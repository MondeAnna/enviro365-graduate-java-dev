package com.enviro.assessment.grad001.mondeanna.service;

import com.enviro.assessment.grad001.mondeanna.model.RecyclingTip;
import com.enviro.assessment.grad001.mondeanna.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipServices {

    private final RecyclingTipRepository repository;

    @Autowired
    public RecyclingTipServices( RecyclingTipRepository repository ){
        this.repository = repository;
    }

    public RecyclingTip save(RecyclingTip tip ){
        return repository.save( tip );
    }

    public List<RecyclingTip> findAll(){
        return repository.findAll();
    }

    public Optional<RecyclingTip> findById( long id ){
        return repository.findById( id );
    }

    public Optional<RecyclingTip> update( long id, RecyclingTip tip ){
        if ( !repository.existsById( id ))
            return Optional.empty();
        tip.setId( id );
        return Optional.of( repository.save( tip ));
    }

    public boolean delete( long id ){
        if ( !repository.existsById( id ))
            return false;
        repository.deleteById( id );
        return true;
    }
}
