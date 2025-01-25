package com.enviro.assessment.grad001.mondeanna.disposal.unit;

import com.enviro.assessment.grad001.mondeanna.disposal.TestData;
import com.enviro.assessment.grad001.mondeanna.disposal.DisposalGuideline;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DisposalGuidelineTest {

    @Test
    public void testClassClassificationValue(){
        DisposalGuideline validClassification = TestData.validClassification();

        assertThat( validClassification.getId() ).isEqualTo( 1 );
        assertThat( validClassification.getClassification() ).isEqualTo( "A" );
        assertThat( validClassification.getDescription() ).isEqualTo( "a long description" );
        assertThat( validClassification.getWasteCategory() ).isEqualTo( "waste category" );
        assertThat( validClassification.getLandfill() ).isEqualTo( "landfill shorthand" );
    }
}
