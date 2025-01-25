package com.enviro.assessment.grad001.mondeanna.disposal.unit;

import com.enviro.assessment.grad001.mondeanna.disposal.TestData;
import com.enviro.assessment.grad001.mondeanna.disposal.DisposalGuideline;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class DisposalGuidelineTest {

    private Validator validator;

    @BeforeEach
    public void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testClassClassificationValue(){
        DisposalGuideline validClassification = TestData.validClassification();

        assertThat( validClassification.getId() ).isEqualTo( 1 );
        assertThat( validClassification.getClassification() ).isEqualTo( "A" );
        assertThat( validClassification.getDescription() ).isEqualTo( "a long description" );
        assertThat( validClassification.getWasteCategory() ).isEqualTo( "waste category" );
        assertThat( validClassification.getLandfill() ).isEqualTo( "landfill shorthand" );
    }

    @Test
    public void testInvalidClassification(){
        DisposalGuideline blankDescription = TestData.blankClassification();

        Set<ConstraintViolation<DisposalGuideline>> violations = validator.validate( blankDescription );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        for ( String message : List.of( "Allowed: 'A', 'B', 'C' or 'D'", "must not be blank" ))
            assertThat( messages.contains( message )).isTrue();
    }
}
