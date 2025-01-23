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

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ControllerTest {

    @Mock
    private WasteRepository repository;

    @InjectMocks
    private WasteController controller;

    private final List<Waste> mockRepo = TestData.mockRepo();

    @Test
    public void testFindAll(){
        when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll().size() ).isEqualTo( 3 );
    }

    @Test
    public void testFindById(){
        Waste xylenes = new Waste( "Xylenes", "(CH3)2C6H4", 0.0, 890, 3_560, 0, 25, 50, 200 );

        when( repository.findById( "(CH3)2C6H4" )).thenReturn( Optional.of( xylenes ));
        assertThat( controller.findById( "(CH3)2C6H4" )).isEqualTo( Optional.of( TestData.xylenes() ));
    }
}
