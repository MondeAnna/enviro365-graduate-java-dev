package com.enviro.assessment.grad001.mondeanna.disposal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Null;

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
        @Column( unique = true )
        private String name;

        @NotBlank
        @Column( unique = true )
        private String description;
}
