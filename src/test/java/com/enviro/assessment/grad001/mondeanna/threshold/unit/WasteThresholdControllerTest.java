package com.enviro.assessment.grad001.mondeanna.threshold.unit;

import com.enviro.assessment.grad001.mondeanna.threshold.TestData;
import com.enviro.assessment.grad001.mondeanna.threshold.WasteThresholdController;
import com.enviro.assessment.grad001.mondeanna.threshold.WasteThreshold;
import com.enviro.assessment.grad001.mondeanna.threshold.WasteThresholdRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WasteThresholdControllerTest {

    @Mock
    private WasteThresholdRepository repository;

    @InjectMocks
    private WasteThresholdController controller;

    private final List<WasteThreshold> mockRepo = TestData.mockWasteThresholdRepo();

    @Test
    public void testFindAll(){
        when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll().size() ).isEqualTo( 3 );
    }

    @Test
    public void testFindById(){
        WasteThreshold xylenes = TestData.xylenes();

        when( repository.findById( xylenes.getId() )).thenReturn( Optional.of( xylenes ));
        assertThat( controller.findById(xylenes.getId() )).isEqualTo( Optional.of( xylenes ));
    }
}
