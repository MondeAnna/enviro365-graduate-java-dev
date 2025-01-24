package com.enviro.assessment.grad001.mondeanna.waste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServices( CategoryRepository repository ){
        this.repository = repository;
    }

    public Category save( Category category ){
        return repository.save( category );
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Optional<Category> findById( long id ){
        return repository.findById( id );
    }

    public Optional<Category> update( long id, Category category ){
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
