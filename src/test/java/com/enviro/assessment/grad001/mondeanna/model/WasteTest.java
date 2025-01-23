package com.enviro.assessment.grad001.mondeanna.model;

import com.enviro.assessment.grad001.mondeanna.TestData;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WasteTest {

    @Test
    void testInstanceConstruction(){
        Waste zinc = TestData.zinc();

        assertThat( zinc.getSubstance() ).isEqualTo( "Zinc" );
        assertThat( zinc.getFormula() ).isEqualTo( "Zn" );

        assertThat( zinc.getTotalConcentrationThresholdZero() ).isEqualTo( 240 );
        assertThat( zinc.getTotalConcentrationThresholdOne() ).isEqualTo( 160_000 );
        assertThat( zinc.getTotalConcentrationThresholdTwo() ).isEqualTo( 640_000 );

        assertThat( zinc.getLeachableConcentrationThresholdZero() ).isEqualTo( 5 );
        assertThat( zinc.getLeachableConcentrationThresholdOne() ).isEqualTo( 250 );
        assertThat( zinc.getLeachableConcentrationThresholdTwo() ).isEqualTo( 500 );
        assertThat( zinc.getLeachableConcentrationThresholdThree() ).isEqualTo( 2_000 );
    }
}
