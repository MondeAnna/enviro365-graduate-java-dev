package com.enviro.assessment.grad001.mondeanna.waste;

import java.util.List;

public class TestData {

    public static Category typeTwo(){
        return Category.builder()
                .id( 2L )
                .name( "Type2" )
                .description("""
                        leachable concentration between 1 and 2 as well as \
                        total concentration less that level 1 is type 2
                        """ )
                .build();
    }

    public static Category typeTwenty(){
        return Category.builder()
                .id( 20L )
                .name( "Type20" )
                .description("""
                        wastes with element or chemical substances \
                        concentration above level waste type 20
                        """ )
                .build();
    }

    public static List<Category> mockCategoryRepo(){
        return List.of( typeTwo(), typeTwenty() );
    }
}
