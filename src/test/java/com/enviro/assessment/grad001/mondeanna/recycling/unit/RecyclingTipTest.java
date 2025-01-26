package com.enviro.assessment.grad001.mondeanna.recycling.unit;

import com.enviro.assessment.grad001.mondeanna.recycling.TestData;
import com.enviro.assessment.grad001.mondeanna.recycling.RecyclingTip;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RecyclingTipTest {

    private RecyclingTip tip;
    private Validator validator;

    @BeforeEach
    public void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testClassClassificationValue(){
        tip = TestData.validTip();

        assertThat( tip.getId() ).isEqualTo( 1 );
        assertThat( tip.getClassification() ).isEqualTo( "A" );
        assertThat( tip.getDescription() ).isEqualTo( "a long description" );
        assertThat( tip.getWasteCategory() ).isEqualTo( "waste category" );
        assertThat( tip.getLandfill() ).isEqualTo( "landfill shorthand" );
    }

    @Test
    public void testInvalidClassification(){
        tip = TestData.blankClassification();

        Set<ConstraintViolation<RecyclingTip>> violations = validator.validate( tip );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        for ( String message : List.of( "Allowed: 'A', 'B', 'C' or 'D'", "must not be blank" ))
            assertThat( messages.contains( message )).isTrue();
    }

    @Test
    public void testInvalidWasteCategory(){
        tip = TestData.blankWasteCategory();

        Set<ConstraintViolation<RecyclingTip>> violations = validator.validate( tip );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        assertThat( messages ).isEqualTo( List.of( "must not be blank" ));
    }

    @Test
    public void testInvalidDescription(){
        tip = TestData.blankLandfill();

        Set<ConstraintViolation<RecyclingTip>> violations = validator.validate( tip );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        assertThat( messages ).isEqualTo( List.of( "must not be blank" ));
    }
}
