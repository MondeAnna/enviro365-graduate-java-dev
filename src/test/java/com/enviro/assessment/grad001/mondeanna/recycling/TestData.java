package com.enviro.assessment.grad001.mondeanna.recycling;

import java.util.List;

public class TestData {

    public static RecyclingTip validExample(){
        return RecyclingTip.builder()
                .id( 1L )
                .tip( "Check Water Sources" )
                .description( "Do not let taps, showers and hose pipes run unattended" )
                .build();
    }

    public static RecyclingTip invalidTip() {
        return RecyclingTip.builder()
                .tip( "" )
                .description( "description" )
                .build();
    }

    public static RecyclingTip invalidDescription() {
        return RecyclingTip.builder()
                .tip( "tip" )
                .description( "" )
                .build();
    }

    public static List<RecyclingTip> mockRecyclingTipRepo(){
        return List.of( validExample() );
    }
}
