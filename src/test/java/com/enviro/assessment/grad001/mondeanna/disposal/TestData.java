package com.enviro.assessment.grad001.mondeanna.disposal;

import java.util.List;

public class TestData {

    public static DisposalGuideline validClassification(){
        return DisposalGuideline.builder()
                .id( 1L )
                .classification( "A" )
                .description( "a long description" )
                .wasteCategory( "waste category" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static DisposalGuideline blankClassification() {
        return DisposalGuideline.builder()
                .classification( "" )
                .description( "description" )
                .wasteCategory( "waste category" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static DisposalGuideline blankWasteCategory() {
        return DisposalGuideline.builder()
                .classification( "B" )
                .description( "description" )
                .wasteCategory( "" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static DisposalGuideline blankDescription() {
        return DisposalGuideline.builder()
                .classification( "C" )
                .description( "" )
                .wasteCategory( "category" )
                .landfill( "landfill shorthand" )
                .build();
    }

    public static DisposalGuideline blankLandfill() {
        return DisposalGuideline.builder()
                .classification( "D" )
                .description( "description" )
                .wasteCategory( "category" )
                .landfill( "" )
                .build();
    }

    public static List<DisposalGuideline> mockDisposalGuidelineRepo(){
        return List.of( validClassification() );
    }
}
