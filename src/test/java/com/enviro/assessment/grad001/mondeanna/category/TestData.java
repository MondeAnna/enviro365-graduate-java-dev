package com.enviro.assessment.grad001.mondeanna.category;

import java.util.List;

public class TestData {

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
