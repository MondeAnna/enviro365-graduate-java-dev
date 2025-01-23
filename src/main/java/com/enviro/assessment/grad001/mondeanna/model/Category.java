package com.enviro.assessment.grad001.mondeanna.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "categories" )
public class Category {

        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        private Long id;

        @NotBlank
        @Column( unique = true )
        private String name;

        @NotBlank
        @Column( unique = true )
        private String description;
}
