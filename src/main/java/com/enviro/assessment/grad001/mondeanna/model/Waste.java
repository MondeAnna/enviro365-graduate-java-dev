package com.enviro.assessment.grad001.mondeanna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table( name = "wastes" )
public record Waste(

        @Id @NotBlank String formula,
        @NotBlank String substance,
        @PositiveOrZero double totalLevelZero,
        @PositiveOrZero double totalLevelOne,
        @PositiveOrZero double totalLevelTwo,
        @PositiveOrZero double leachableLevelZero,
        @PositiveOrZero double leachableLevelOne,
        @PositiveOrZero double leachableLevelTwo,
        @PositiveOrZero double leachableLevelThree ){
}
