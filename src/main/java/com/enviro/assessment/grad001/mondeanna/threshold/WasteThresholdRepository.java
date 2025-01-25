package com.enviro.assessment.grad001.mondeanna.threshold;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteThresholdRepository extends
        JpaRepository<WasteThreshold, Long> {
}
