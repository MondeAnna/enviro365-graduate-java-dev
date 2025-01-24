package com.enviro.assessment.grad001.mondeanna.waste.unit;

import com.enviro.assessment.grad001.mondeanna.waste.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

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
    public void testFindAll(){
        Mockito.when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll() ).isEqualTo( ResponseEntity.ok( mockRepo ));
    }

    @Test
    @Disabled
    public void testFindById(){
        Category typeTwo = TestData.typeTwo();
        when( repository.findById( 2L )).thenReturn( Optional.of( typeTwo ));
        assertThat( controller.findById( 2L )).isEqualTo( Optional.of( typeTwo ));
    }

    @Test
    @Disabled
    public void testSave(){
        Category typeTwenty = TestData.typeTwenty();
        when( repository.save( typeTwenty )).thenReturn( typeTwenty );
        assertThat( controller.save( typeTwenty )).isEqualTo( typeTwenty );
    }

    @Test
    @Disabled
    public void testUpdate(){
        Category typeTwo = TestData.typeTwo();
        Category typeFour = TestData.typeTwo();
        typeFour.setId( 4L );

        when( repository.save( typeTwo )).thenReturn( typeFour );
        assertThat( controller.update( 4L, typeTwo )).isEqualTo( typeFour );
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
