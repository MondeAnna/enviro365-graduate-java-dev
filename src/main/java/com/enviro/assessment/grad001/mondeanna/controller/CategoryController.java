package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.model.Category;
import com.enviro.assessment.grad001.mondeanna.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( path = "/api/v1/categories" )
public class CategoryController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryController( CategoryRepository repository ){
        this.repository = repository;
    }

    @GetMapping( path = "/" )
    public List<Category> findAll() {
        return repository.findAll();
    }
}
