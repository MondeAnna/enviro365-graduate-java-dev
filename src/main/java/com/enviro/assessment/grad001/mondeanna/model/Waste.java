package com.enviro.assessment.grad001.mondeanna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "wastes" )
public class Waste {

        @NotBlank
        private String substance;

        @Id @NotBlank
        private String formula;

        @PositiveOrZero
        private double totalConcentrationThresholdZero;

        @PositiveOrZero
        private double totalConcentrationThresholdOne;

        @PositiveOrZero
        private double totalConcentrationThresholdTwo;

        @PositiveOrZero
        private double leachableConcentrationThresholdZero;

        @PositiveOrZero
        private double leachableConcentrationThresholdOne;

        @PositiveOrZero
        private double leachableConcentrationThresholdTwo;

        @PositiveOrZero
        private double leachableConcentrationThresholdThree;
}
