package com.enviro.assessment.grad001.mondeanna.waste.unit;

import com.enviro.assessment.grad001.mondeanna.waste.Category;
import com.enviro.assessment.grad001.mondeanna.waste.CategoryRepository;
import com.enviro.assessment.grad001.mondeanna.waste.CategoryServices;
import com.enviro.assessment.grad001.mondeanna.waste.TestData;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryServicesTest {

    @Mock
    private CategoryRepository repository;

    @InjectMocks
    private CategoryServices service;

    private final List<Category> mockRepo = TestData.mockCategoryRepo();

    @Test
    public void testFindAll(){
        Mockito.when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( service.findAll() ).isEqualTo( mockRepo );
    }

    @Test
    public void testFindById(){
        Category typeTwo = TestData.typeTwo();
        Mockito.when( repository.findById( 2L )).thenReturn( Optional.of( typeTwo ));
        assertThat( service.findById( 2L )).isEqualTo( Optional.of( typeTwo ));
    }

    @Test
    public void testSave(){
        Category typeTwenty = TestData.typeTwenty();
        Mockito.when( repository.save( typeTwenty )).thenReturn( typeTwenty );
        assertThat( service.save( typeTwenty )).isEqualTo( typeTwenty );
    }

    @Test
    public void testUpdate(){
        Category typeTwo = TestData.typeTwo();
        Category typeFour = TestData.typeTwo();
        typeFour.setId( 4L );

        Mockito.when( repository.save( typeTwo )).thenReturn( typeFour );
        assertThat( service.update( 4L, typeTwo )).isEqualTo( typeFour );
    }

    @Test
    public void testDeleteWithInvalidArgument(){
        Mockito.when( repository.existsById( 1000L )).thenReturn( false );
        assertThat( service.delete( 1000L )).isEqualTo( false );
    }

    @Test
    public void testDelete(){
        Mockito.when( repository.existsById( 20L )).thenReturn( true );
        assertThat( service.delete( 20L )).isEqualTo( true );
    }
}
