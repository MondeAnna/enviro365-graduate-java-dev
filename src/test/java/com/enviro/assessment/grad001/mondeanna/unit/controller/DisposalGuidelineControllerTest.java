package com.enviro.assessment.grad001.mondeanna.unit.controller;

import com.enviro.assessment.grad001.mondeanna.controller.DisposalGuidelineController;
import com.enviro.assessment.grad001.mondeanna.unit.TestData;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import com.enviro.assessment.grad001.mondeanna.model.DisposalGuideline;
import com.enviro.assessment.grad001.mondeanna.service.DisposalGuidelineServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DisposalGuidelineControllerTest {

    @Mock
    private DisposalGuidelineServices services;

    @InjectMocks
    private DisposalGuidelineController controller;

    private final List<DisposalGuideline> mockRepo = TestData.mockDisposalGuidelineRepo();
    private final DisposalGuideline guideline = TestData.validGuideline();

    @Test
    public void testSave(){
        URI uri = URI.create( "/api/v1/disposal-guidelines/1" );
        ResponseEntity<URI> expected =  ResponseEntity.created( uri ).build();

        Mockito.when( services.save( guideline )).thenReturn( guideline );
        assertThat( controller.save( guideline )).isEqualTo( expected );
    }

    @Test
    public void testFindAll(){
        Mockito.when( services.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll() ).isEqualTo( ResponseEntity.ok( mockRepo ));
    }

    @Test
    public void testFindById(){
        Mockito.when( services.findById( 2L )).thenReturn( Optional.of( guideline ));
        assertThat( controller.findById( 2L )).isEqualTo( ResponseEntity.ok( guideline ));
    }

    @Test
    public void testFindByIdWithInvalidArg(){
        Mockito.when( services.findById( anyLong() )).thenReturn( Optional.empty() );
        assertThat( controller.findById( 2L )).isEqualTo( ResponseEntity.badRequest().build() );
    }

    @Test
    public void testUpdate(){
        DisposalGuideline updated = TestData.validGuideline();

        updated.setClassification( "updated classification" );
        updated.setWasteCategory( "updated waste category" );
        updated.setDescription( "updated description" );
        updated.setLandfill( "updated landfill" );

        assertThat( guideline ).isNotEqualTo( updated );

        Mockito.when( services.update( 2L, guideline )).thenReturn( Optional.of( updated ));
        assertThat( controller.update( 2L, guideline )).isEqualTo( ResponseEntity.ok( updated ));
    }

    @Test
    public void testUpdateWithInvalidArgs(){
        ResponseEntity<DisposalGuideline> expected = ResponseEntity.badRequest().build();

        Mockito.when( services.update( anyLong(), any() )).thenReturn( Optional.empty() );
        assertThat( controller.update( 20L, guideline )).isEqualTo( expected );
    }

    @Test
    public void testDeleteWithInvalidArgument(){
        ResponseEntity<String> expected = ResponseEntity.badRequest( ).body( "Invalid Argument" );
        Mockito.when( services.delete( anyLong() )).thenReturn( false );
        assertThat( controller.delete( 1000L )).isEqualTo( expected );
    }

    @Test
    public void testDelete(){
        ResponseEntity<String> expected = ResponseEntity.ok().body( "Disposal Guideline ID of 20 deleted" );
        Mockito.when( services.delete( 20L )).thenReturn( true );
        assertThat( controller.delete( 20L )).isEqualTo( expected );
    }
}
