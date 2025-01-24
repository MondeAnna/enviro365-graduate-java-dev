package com.enviro.assessment.grad001.mondeanna.waste.unit;

import com.enviro.assessment.grad001.mondeanna.waste.TestData;
import com.enviro.assessment.grad001.mondeanna.waste.ThresholdController;
import com.enviro.assessment.grad001.mondeanna.waste.Threshold;
import com.enviro.assessment.grad001.mondeanna.waste.ThresholdRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class ThresholdControllerTest {

    @Mock
    private ThresholdRepository repository;

    @InjectMocks
    private ThresholdController controller;

    private final List<Threshold> mockRepo = TestData.mockThresholdRepo();

    @Test
    public void testFindAll(){
        when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll().size() ).isEqualTo( 3 );
    }

    @Test
    public void testFindById(){
        Threshold xylenes = TestData.xylenes();

        when( repository.findById( xylenes.getId() )).thenReturn( Optional.of( xylenes ));
        assertThat( controller.findById(xylenes.getId() )).isEqualTo( Optional.of( xylenes ));
    }
}
