package com.enviro.assessment.grad001.mondeanna.category;

import com.enviro.assessment.grad001.mondeanna.disposal.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends
        JpaRepository<WasteCategory, Long> {
}
