package com.enviro.assessment.grad001.mondeanna.unit;

import com.enviro.assessment.grad001.mondeanna.model.DisposalGuideline;
import com.enviro.assessment.grad001.mondeanna.model.RecyclingTip;
import com.enviro.assessment.grad001.mondeanna.model.WasteCategory;

import java.util.List;

public class TestData {

    public static DisposalGuideline validGuideline(){
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
        return List.of( validGuideline() );
    }

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

    public static WasteCategory typeTwo(){
        return WasteCategory.builder()
                .id( 2L )
                .name( "Type2" )
                .description("""
                        leachable concentration between 1 and 2 as well as \
                        total concentration less that level 1 is type 2
                        """ )
                .build();
    }

    public static WasteCategory typeTwenty(){
        return WasteCategory.builder()
                .id( 20L )
                .name( "Type20" )
                .description("""
                        wastes with element or chemical substances \
                        concentration above level waste type 20
                        """ )
                .build();
    }

    public static List<WasteCategory> mockWasteCategoryRepo(){
        return List.of( typeTwo(), typeTwenty() );
    }
}
