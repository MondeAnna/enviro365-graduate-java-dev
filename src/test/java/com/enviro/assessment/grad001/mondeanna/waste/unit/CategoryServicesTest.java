package com.enviro.assessment.grad001.mondeanna.waste.unit;

import com.enviro.assessment.grad001.mondeanna.waste.Category;
import com.enviro.assessment.grad001.mondeanna.waste.CategoryRepository;
import com.enviro.assessment.grad001.mondeanna.waste.CategoryServices;
import com.enviro.assessment.grad001.mondeanna.waste.TestData;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryServicesTest {

    @Mock
    private CategoryRepository repository;

    @InjectMocks
    private CategoryServices service;

    private final List<Category> mockRepo = TestData.mockCategoryRepo();

    @Test
    public void testFindAll(){
        when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( service.findAll() ).isEqualTo( mockRepo );
    }

    @Test
    public void testFindById(){
        Category typeTwo = new Category(
                2L,
                "Type2",
                """
                leachable concentration between 1 and 2 as well as \
                total concentration less that level 1 is type 2
                """
        );

        when( repository.findById( 2L )).thenReturn( Optional.of( typeTwo ));
        assertThat( service.findById( 2L )).isEqualTo( Optional.of( TestData.typeTwo() ));
    }

    @Test
    public void testSave(){
        Category typeThree = new Category(
                3L,
                "Type3",
                """
                leachable concentration between 2 and 3 as well as \
                total concentration less that level 2 is type 3
                """
        );

        when( repository.save( typeThree )).thenReturn( typeThree );
        assertThat( service.save( typeThree )).isEqualTo( typeThree );
    }

    @Test
    public void testUpdate(){
        Category typeTwo = TestData.typeTwo();
        Category typeFour = TestData.typeTwo();
        typeFour.setId( 4L );

        when( repository.save( typeTwo )).thenReturn( typeFour );
        assertThat( service.update( 4L, typeTwo )).isEqualTo( typeFour );
    }

    @Test
    public void testDeleteWithInvalidArgument(){
        when( repository.existsById( 1000L )).thenReturn( false );
        assertThat( service.delete( 1000L )).isEqualTo( "Invalid argument" );
    }

    @Test
    public void testDelete(){
        when( repository.existsById( 20L )).thenReturn( true );
        assertThat( service.delete( 20L )).isEqualTo( "ID 20 Category deleted" );
    }
}
