package com.enviro.assessment.grad001.mondeanna.recycling.unit;

import com.enviro.assessment.grad001.mondeanna.recycling.TestData;
import com.enviro.assessment.grad001.mondeanna.recycling.RecyclingTip;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RecyclingTipTest {

    private RecyclingTip tip;

    @Test
    public void testClassClassificationValue(){
        String expectedDescription = "Do not let taps, showers and hose pipes run unattended";
        tip = TestData.validExample();

        assertThat( tip.getId() ).isEqualTo( 1 );
        assertThat( tip.getTip() ).isEqualTo( "Check Water Sources" );
        assertThat( tip.getDescription() ).isEqualTo( expectedDescription );
    }
}
