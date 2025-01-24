package com.enviro.assessment.grad001.mondeanna.waste.unit;

import com.enviro.assessment.grad001.mondeanna.waste.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryControllerTest {

    @Mock
    private CategoryRepository repository;

    @InjectMocks
    private CategoryController controller;

    private final List<Category> mockRepo = TestData.mockCategoryRepo();

    @Test
    public void testSave(){
        Category typeTwenty = TestData.typeTwenty();
        URI uri = URI.create( "/api/v1/categories/20" );
        ResponseEntity<URI> expected =  ResponseEntity.created( uri ).build();

        Mockito.when( repository.save( typeTwenty )).thenReturn( typeTwenty );
        assertThat( controller.save( typeTwenty )).isEqualTo( expected );
    }

    @Test
    public void testFindAll(){
        Mockito.when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll() ).isEqualTo( ResponseEntity.ok( mockRepo ));
    }

    @Test
    public void testFindById(){
        Category typeTwo = TestData.typeTwo();
        Mockito.when( repository.findById( any() )).thenReturn( Optional.of( typeTwo ));
        assertThat( controller.findById( 2L )).isEqualTo( ResponseEntity.ok( typeTwo ));
    }

    @Test
    public void testFindByIdWithInvalidArg(){
        Mockito.when( repository.findById( any() )).thenReturn( Optional.empty() );
        assertThat( controller.findById( 2L )).isEqualTo( ResponseEntity.notFound().build() );
    }

    @Test
    public void testUpdate(){
        Category typeTwo = TestData.typeTwo();
        Category updated = TestData.typeTwo();

        updated.setName( "updated name" );
        updated.setDescription( "updated description" );

        Mockito.when( repository.existsById( 2L )).thenReturn( true );
        Mockito.when( repository.save( typeTwo )).thenReturn( updated );
        assertThat( controller.update( 2L, typeTwo )).isEqualTo( ResponseEntity.ok( updated ));
    }

    @Test
    @Disabled
    public void testDeleteWithInvalidArgument(){
        when( repository.existsById( 1000L )).thenReturn( false );
        assertThat( controller.delete( 1000L )).isEqualTo( "Invalid argument" );
    }

    @Test
    @Disabled
    public void testDelete(){
        when( repository.existsById( 20L )).thenReturn( true );
        assertThat( controller.delete( 20L )).isEqualTo( "ID 20 Category deleted" );
    }
}
