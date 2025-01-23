package com.enviro.assessment.grad001.mondeanna;

import com.enviro.assessment.grad001.mondeanna.model.Waste;

import java.util.Set;

public class TestData {

    public static Set<Waste> mockRepo(){
        return Set.of(
            new Waste( "Zinc", "Zn", 240, 160_000, 640_000, 5, 250, 500, 2_000 ),
            new Waste( "Xylenes", "(CH3)2C6H4", 0.0, 890, 3_560, 0, 25, 50, 200 ),
            new Waste( "Heptachlor", "C10H5Cl7", 0.05, 1.2, 4.8, 0, 0.015, 0.03, 0.03 )
        );
    }
}
