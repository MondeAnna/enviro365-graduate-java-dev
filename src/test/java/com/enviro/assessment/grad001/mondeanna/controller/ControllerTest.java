package com.enviro.assessment.grad001.mondeanna.controller;

import com.enviro.assessment.grad001.mondeanna.TestData;
import com.enviro.assessment.grad001.mondeanna.model.Waste;
import com.enviro.assessment.grad001.mondeanna.repository.WasteRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class ControllerTest {

    @Mock
    private WasteRepository repository;

    @InjectMocks
    private WasteController controller;

    private final Set<Waste> mockRepo = TestData.mockRepo();

    @Test
    public void testFindAll() {
        when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll() ).isEqualTo( mockRepo );
    }
}
