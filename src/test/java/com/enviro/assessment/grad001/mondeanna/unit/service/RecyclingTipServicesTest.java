package com.enviro.assessment.grad001.mondeanna.unit.service;

import com.enviro.assessment.grad001.mondeanna.model.RecyclingTip;
import com.enviro.assessment.grad001.mondeanna.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.mondeanna.service.RecyclingTipServices;
import com.enviro.assessment.grad001.mondeanna.unit.TestData;

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
    private final RecyclingTip tip = TestData.validExample();

    @Test
    public void testFindAll(){
        Mockito.when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( service.findAll() ).isEqualTo( mockRepo );
    }

    @Test
    public void testFindById(){
        Mockito.when( repository.findById( 2L )).thenReturn( Optional.of( tip ));
        assertThat( service.findById( 2L )).isEqualTo( Optional.of( tip ));
    }

    @Test
    public void testSave(){
        Mockito.when( repository.save( tip )).thenReturn( tip );
        assertThat( service.save( tip )).isEqualTo( tip );
    }

    @Test
    public void testUpdate(){
        RecyclingTip updated = TestData.validExample();

        updated.setTip( "updated tip" );
        updated.setDescription( "updated description" );

        assertThat( tip ).isNotEqualTo( updated );

        Mockito.when( repository.existsById( 2L )).thenReturn( true );
        Mockito.when( repository.save( tip )).thenReturn( updated );
        assertThat( service.update( 2L, tip )).isEqualTo( Optional.of( updated ));
    }

    @Test
    public void testUpdateWithInvalidArgs(){
        Mockito.when( repository.existsById( 200L )).thenReturn( false );
        assertThat( service.update( 200L, tip )).isEqualTo( Optional.empty() );
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
