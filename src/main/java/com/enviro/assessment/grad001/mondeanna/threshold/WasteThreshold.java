package com.enviro.assessment.grad001.mondeanna.threshold;

import jakarta.persistence.*;
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
@Table( name = "waste_thresholds" )
public class WasteThreshold {

        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        private Long id;

        @NotBlank
        private String substance;

        @NotBlank
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
