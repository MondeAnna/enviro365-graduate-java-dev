package com.enviro.assessment.grad001.mondeanna.model;

import com.enviro.assessment.grad001.mondeanna.TestData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CategoryTest {

    @Test
    void testInstanceConstruction(){
        Category typeTwenty = TestData.typeTwenty();

        assertThat( typeTwenty.getId() ).isEqualTo( 20 );
        assertThat( typeTwenty.getName() ).isEqualTo( "Type20" );

        String description = typeTwenty.getDescription();

        for ( String expected : new String[]{ "chemical", "substances", "waste", "type", "20" })
            assertThat( description ).contains( expected );
    }
}
