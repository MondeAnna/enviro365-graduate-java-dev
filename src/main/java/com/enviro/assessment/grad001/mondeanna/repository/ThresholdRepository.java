package com.enviro.assessment.grad001.mondeanna.repository;

import com.enviro.assessment.grad001.mondeanna.model.Threshold;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThresholdRepository extends JpaRepository<Threshold, Long> {
}
