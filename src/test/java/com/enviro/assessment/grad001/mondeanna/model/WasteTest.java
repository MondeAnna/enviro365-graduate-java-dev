package com.enviro.assessment.grad001.mondeanna.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WasteTest {

    @Test
    void testInstanceConstruction(){
        Waste zinc = new Waste( "Zinc", "Zn", 240, 160_000, 640_000, 5, 250, 500, 2_000 );

        assertThat( zinc.substance() ).isEqualTo( "Zinc" );
        assertThat( zinc.formula() ).isEqualTo( "Zn" );

        assertThat( zinc.totalConcentrationThresholdZero() ).isEqualTo( 240 );
        assertThat( zinc.totalConcentrationThresholdOne() ).isEqualTo( 160_000 );
        assertThat( zinc.totalConcentrationThresholdTwo() ).isEqualTo( 640_000 );

        assertThat( zinc.leachableConcentrationThresholdZero() ).isEqualTo( 5 );
        assertThat( zinc.leachableConcentrationThresholdOne() ).isEqualTo( 250 );
        assertThat( zinc.leachableConcentrationThresholdTwo() ).isEqualTo( 500 );
        assertThat( zinc.leachableConcentrationThresholdThree() ).isEqualTo( 2_000 );
    }
}
