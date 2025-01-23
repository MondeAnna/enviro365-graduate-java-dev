package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.TestData;
import com.enviro.assessment.grad001.mondeanna.model.Category;
import com.enviro.assessment.grad001.mondeanna.repository.CategoryRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

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
        when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll().size() ).isEqualTo( 2 );
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
        assertThat( controller.findById( 2L )).isEqualTo( Optional.of( TestData.typeTwo() ));
    }
}
