package com.enviro.assessment.grad001.mondeanna.unit.controller;

import com.enviro.assessment.grad001.mondeanna.model.RecyclingTip;
import com.enviro.assessment.grad001.mondeanna.controller.RecyclingTipController;
import com.enviro.assessment.grad001.mondeanna.service.RecyclingTipServices;
import com.enviro.assessment.grad001.mondeanna.unit.TestData;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class RecyclingTipControllerTest {

    @Mock
    private RecyclingTipServices services;

    @InjectMocks
    private RecyclingTipController controller;

    private final List<RecyclingTip> mockRepo = TestData.mockRecyclingTipRepo();
    private final RecyclingTip guideline = TestData.validExample();

    @Test
    public void testSave(){
        URI uri = URI.create( "/api/v1/recycling-tips/1" );
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
        RecyclingTip updated = TestData.validExample();

        updated.setTip( "updated tip" );
        updated.setDescription( "updated description" );

        assertThat( guideline ).isNotEqualTo( updated );

        Mockito.when( services.update( 2L, guideline )).thenReturn( Optional.of( updated ));
        assertThat( controller.update( 2L, guideline )).isEqualTo( ResponseEntity.ok( updated ));
    }

    @Test
    public void testUpdateWithInvalidArgs(){
        ResponseEntity<RecyclingTip> expected = ResponseEntity.badRequest().build();

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
        ResponseEntity<String> expected = ResponseEntity.ok().body( "Recycling Tip ID of 20 deleted" );
        Mockito.when( services.delete( 20L )).thenReturn( true );
        assertThat( controller.delete( 20L )).isEqualTo( expected );
    }
}
