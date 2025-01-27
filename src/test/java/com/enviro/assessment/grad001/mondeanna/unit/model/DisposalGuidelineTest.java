package com.enviro.assessment.grad001.mondeanna.unit.model;

import com.enviro.assessment.grad001.mondeanna.unit.TestData;
import com.enviro.assessment.grad001.mondeanna.model.DisposalGuideline;

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

    private DisposalGuideline guideline;
    private Validator validator;

    @BeforeEach
    public void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testClassClassificationValue(){
        guideline = TestData.validGuideline();

        assertThat( guideline.getId() ).isEqualTo( 1 );
        assertThat( guideline.getClassification() ).isEqualTo( "A" );
        assertThat( guideline.getDescription() ).isEqualTo( "a long description" );
        assertThat( guideline.getWasteCategory() ).isEqualTo( "waste category" );
        assertThat( guideline.getLandfill() ).isEqualTo( "landfill shorthand" );
    }

    @Test
    public void testInvalidClassification(){
        guideline = TestData.blankClassification();

        Set<ConstraintViolation<DisposalGuideline>> violations = validator.validate( guideline );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        for ( String message : List.of( "Allowed: 'A', 'B', 'C' or 'D'", "must not be blank" ))
            assertThat( messages.contains( message )).isTrue();
    }

    @Test
    public void testInvalidWasteCategory(){
        guideline = TestData.blankWasteCategory();

        Set<ConstraintViolation<DisposalGuideline>> violations = validator.validate( guideline );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        assertThat( messages ).isEqualTo( List.of( "must not be blank" ));
    }

    @Test
    public void testInvalidDescription(){
        guideline = TestData.blankLandfill();

        Set<ConstraintViolation<DisposalGuideline>> violations = validator.validate( guideline );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        assertThat( messages ).isEqualTo( List.of( "must not be blank" ));
    }
}
