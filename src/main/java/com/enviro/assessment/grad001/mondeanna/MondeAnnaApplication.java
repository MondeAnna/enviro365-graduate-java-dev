package com.enviro.assessment.grad001.mondeanna;

import com.enviro.assessment.grad001.mondeanna.model.Waste;
import com.enviro.assessment.grad001.mondeanna.repository.WasteRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MondeAnnaApplication {

	public static void main(String[] args){
		ConfigurableApplicationContext context = SpringApplication.run(MondeAnnaApplication.class, args);
		WasteRepository repository = context.getBean( WasteRepository.class );
		Waste xylenes = Waste.builder()
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
		repository.save( xylenes );
	}
}
