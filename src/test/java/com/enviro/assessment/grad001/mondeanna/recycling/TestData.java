package com.enviro.assessment.grad001.mondeanna.recycling;

import java.util.List;

public class TestData {

    public static RecyclingTip validTip(){
        return RecyclingTip.builder()
                .id( 1L )
                .classification( "A" )
                .description( "a long description" )
                .wasteCategory( "waste category" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static RecyclingTip blankClassification() {
        return RecyclingTip.builder()
                .classification( "" )
                .description( "description" )
                .wasteCategory( "waste category" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static RecyclingTip blankWasteCategory() {
        return RecyclingTip.builder()
                .classification( "B" )
                .description( "description" )
                .wasteCategory( "" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static RecyclingTip blankDescription() {
        return RecyclingTip.builder()
                .classification( "C" )
                .description( "" )
                .wasteCategory( "category" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static RecyclingTip blankLandfill() {
        return RecyclingTip.builder()
                .classification( "D" )
                .description( "description" )
                .wasteCategory( "category" )
                .landfill( "" )
                .build();
    }

    public static List<RecyclingTip> mockRecyclingTipRepo(){
        return List.of( validTip() );
    }
}
