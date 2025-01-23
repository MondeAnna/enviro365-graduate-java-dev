package com.enviro.assessment.grad001.mondeanna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table( name = "wastes" )
public record Waste(

        @NotBlank String substance,
        @Id @NotBlank String formula,
        @PositiveOrZero double totalConcentrationThresholdZero,
        @PositiveOrZero double totalConcentrationThresholdOne,
        @PositiveOrZero double totalConcentrationThresholdTwo,
        @PositiveOrZero double leachableConcentrationThresholdZero,
        @PositiveOrZero double leachableConcentrationThresholdOne,
        @PositiveOrZero double leachableConcentrationThresholdTwo,
        @PositiveOrZero double leachableConcentrationThresholdThree ){
}
