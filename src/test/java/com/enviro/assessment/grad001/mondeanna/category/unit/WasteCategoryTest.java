package com.enviro.assessment.grad001.mondeanna.category.unit;

import com.enviro.assessment.grad001.mondeanna.category.TestData;
import com.enviro.assessment.grad001.mondeanna.category.WasteCategory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class WasteCategoryTest {

    @Test
    void testInstanceConstruction(){
        WasteCategory typeTwenty = TestData.typeTwenty();

        assertThat( typeTwenty.getId() ).isEqualTo( 20 );
        assertThat( typeTwenty.getName() ).isEqualTo( "Type20" );

        String description = typeTwenty.getDescription();

        for ( String expected : new String[]{ "chemical", "substances", "waste", "type", "20" })
            assertThat( description ).contains( expected );
    }
}
