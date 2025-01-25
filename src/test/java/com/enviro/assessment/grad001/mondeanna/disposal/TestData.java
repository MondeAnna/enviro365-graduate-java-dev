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

    /* temporarily unused
    public static DisposalGuideline typeTwo(){
        return DisposalGuideline.builder()
                .id( 2L )
                .name( "Type2" )
                .description("""
                        leachable concentration between 1 and 2 as well as \
                        total concentration less that level 1 is type 2
                        """ )
                .build();
    }

    public static DisposalGuideline typeTwenty(){
        return DisposalGuideline.builder()
                .id( 20L )
                .name( "Type20" )
                .description("""
                        wastes with element or chemical substances \
                        concentration above level waste type 20
                        """ )
                .build();
    }

    public static List<DisposalGuideline> mockDisposalGuidelineRepo(){
        return List.of( typeTwo(), typeTwenty() );
    }
    */
}
