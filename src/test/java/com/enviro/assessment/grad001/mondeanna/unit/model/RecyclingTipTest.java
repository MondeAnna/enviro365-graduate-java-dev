package com.enviro.assessment.grad001.mondeanna.unit.model;

import com.enviro.assessment.grad001.mondeanna.model.RecyclingTip;
import com.enviro.assessment.grad001.mondeanna.unit.TestData;

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

    private final List<String> validationMessages = List.of( "must not be blank" );
    private RecyclingTip tip;
    private Validator validator;

    @BeforeEach
    public void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testClassClassificationValue(){
        String expectedDescription = "Do not let taps, showers and hose pipes run unattended";
        tip = TestData.validExample();

        assertThat( tip.getId() ).isEqualTo( 1 );
        assertThat( tip.getTip() ).isEqualTo( "Check Water Sources" );
        assertThat( tip.getDescription() ).isEqualTo( expectedDescription );
    }

    @Test
    public void testInvalidTip(){
        tip = TestData.invalidTip();

        Set<ConstraintViolation<RecyclingTip>> violations = validator.validate( tip );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        assertThat( messages ).isEqualTo( validationMessages );
    }

    @Test
    public void testInvalidDescription(){
        tip = TestData.invalidDescription();

        Set<ConstraintViolation<RecyclingTip>> violations = validator.validate( tip );
        List<String> messages = violations.stream().map( ConstraintViolation::getMessage ).toList();

        assertThat( messages ).isEqualTo( List.of( "must not be blank" ));
    }
}
