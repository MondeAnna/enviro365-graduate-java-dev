package com.enviro.assessment.grad001.mondeanna.disposal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "disposal_guidelines" )
public class DisposalGuideline {

        @Id
        @Null
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        private Long id;

        @NotBlank
        @Pattern( regexp = "[A-D]", message = "Allowed: 'A', 'B', 'C' or 'D'" )
        private String classification;

        @NotBlank
        @Column( unique = true )
        private String wasteCategory;

        @NotBlank
        @Column( unique = true )
        private String description;

        @NotBlank
        @Column( unique = true )
        private String landfill;
}
