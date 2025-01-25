package com.enviro.assessment.grad001.mondeanna.threshold;

import java.util.List;

public class TestData {

    public static WasteThreshold zinc(){
        return WasteThreshold.builder()
                .id( 1L )
                .substance( "Zinc" )
                .formula( "Zn" )
                .totalConcentrationThresholdZero( 240 )
                .totalConcentrationThresholdOne( 160_000 )
                .totalConcentrationThresholdTwo( 640_000 )
                .leachableConcentrationThresholdZero( 5 )
                .leachableConcentrationThresholdOne( 250 )
                .leachableConcentrationThresholdTwo( 500 )
                .leachableConcentrationThresholdThree( 2_000 )
                .build();
    }
    public static WasteThreshold xylenes(){
        return WasteThreshold.builder()
                .id( 10L )
                .substance( "Xylenes" )
                .formula( "(CH3)2C6H4" )
                .totalConcentrationThresholdZero( 0.0 )
                .totalConcentrationThresholdOne( 890 )
                .totalConcentrationThresholdTwo( 3_560 )
                .leachableConcentrationThresholdZero( 0 )
                .leachableConcentrationThresholdOne( 25 )
                .leachableConcentrationThresholdTwo( 50 )
                .leachableConcentrationThresholdThree( 200 )
                .build();
    }

    public static WasteThreshold heptachlor(){
        return WasteThreshold.builder()
                .id( 100L )
                .substance( "Heptachlor" )
                .formula( "C10H5Cl7" )
                .totalConcentrationThresholdZero( 0.05 )
                .totalConcentrationThresholdOne( 1.2 )
                .totalConcentrationThresholdTwo( 4.8 )
                .leachableConcentrationThresholdZero( 0 )
                .leachableConcentrationThresholdOne( 0.015 )
                .leachableConcentrationThresholdTwo( 0.03 )
                .leachableConcentrationThresholdThree( 0.03 )
                .build();
    }

    public static List<WasteThreshold> mockWasteThresholdRepo(){
        return List.of( zinc(), xylenes(), heptachlor() );
    }
}
