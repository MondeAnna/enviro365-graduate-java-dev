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
}
