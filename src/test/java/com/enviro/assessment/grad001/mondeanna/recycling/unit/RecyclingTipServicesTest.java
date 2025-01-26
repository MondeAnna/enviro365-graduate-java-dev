package com.enviro.assessment.grad001.mondeanna.recycling.unit;

import com.enviro.assessment.grad001.mondeanna.recycling.RecyclingTip;
import com.enviro.assessment.grad001.mondeanna.recycling.RecyclingTipRepository;
import com.enviro.assessment.grad001.mondeanna.recycling.RecyclingTipServices;
import com.enviro.assessment.grad001.mondeanna.recycling.TestData;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RecyclingTipServicesTest {

    @Mock
    private RecyclingTipRepository repository;

    @InjectMocks
    private RecyclingTipServices service;

    private final List<RecyclingTip> mockRepo = TestData.mockRecyclingTipRepo();
    private final RecyclingTip guideline = TestData.validTip();

    @Test
    public void testFindAll(){
        Mockito.when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( service.findAll() ).isEqualTo( mockRepo );
    }

    @Test
    public void testFindById(){
        Mockito.when( repository.findById( 2L )).thenReturn( Optional.of( guideline ));
        assertThat( service.findById( 2L )).isEqualTo( Optional.of( guideline ));
    }

    @Test
    public void testSave(){
        Mockito.when( repository.save( guideline )).thenReturn( guideline );
        assertThat( service.save( guideline )).isEqualTo( guideline );
    }

    @Test
    public void testUpdate(){
        RecyclingTip updated = TestData.validTip();

        updated.setClassification( "updated classification" );
        updated.setDescription( "updated description" );
        updated.setWasteCategory( "updated waste category" );
        updated.setLandfill( "updated landfill" );

        assertThat( guideline ).isNotEqualTo( updated );

        Mockito.when( repository.existsById( 2L )).thenReturn( true );
        Mockito.when( repository.save( guideline )).thenReturn( updated );
        assertThat( service.update( 2L, guideline )).isEqualTo( Optional.of( updated ));
    }

    @Test
    public void testUpdateWithInvalidArgs(){
        Mockito.when( repository.existsById( 200L )).thenReturn( false );
        assertThat( service.update( 200L, guideline )).isEqualTo( Optional.empty() );
    }

    @Test
    public void testDelete(){
        Mockito.when( repository.existsById( 20L )).thenReturn( true );
        assertThat( service.delete( 20L )).isEqualTo( true );
    }

    @Test
    public void testDeleteWithInvalidArgument(){
        Mockito.when( repository.existsById( 1000L )).thenReturn( false );
        assertThat( service.delete( 1000L )).isEqualTo( false );
    }
}
