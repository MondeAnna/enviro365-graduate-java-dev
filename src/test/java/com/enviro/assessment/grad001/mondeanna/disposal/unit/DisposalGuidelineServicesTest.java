package com.enviro.assessment.grad001.mondeanna.disposal.unit;

import com.enviro.assessment.grad001.mondeanna.disposal.DisposalGuideline;
import com.enviro.assessment.grad001.mondeanna.disposal.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.mondeanna.disposal.DisposalGuidelineServices;
import com.enviro.assessment.grad001.mondeanna.disposal.TestData;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DisposalGuidelineServicesTest {

    /* temporarily unused
    @Mock
    private DisposalGuidelineRepository repository;

    @InjectMocks
    private DisposalGuidelineServices service;

    private final List<DisposalGuideline> mockRepo = TestData.mockDisposalGuidelineRepo();

    @Test
    public void testFindAll(){
        Mockito.when( repository.findAll() ).thenReturn( mockRepo );
        assertThat( service.findAll() ).isEqualTo( mockRepo );
    }

    @Test
    public void testFindById(){
        DisposalGuideline typeTwo = TestData.typeTwo();
        Mockito.when( repository.findById( 2L )).thenReturn( Optional.of( typeTwo ));
        assertThat( service.findById( 2L )).isEqualTo( Optional.of( typeTwo ));
    }

    @Test
    public void testSave(){
        DisposalGuideline typeTwenty = TestData.typeTwenty();
        Mockito.when( repository.save( typeTwenty )).thenReturn( typeTwenty );
        assertThat( service.save( typeTwenty )).isEqualTo( typeTwenty );
    }

    @Test
    public void testUpdate(){
        DisposalGuideline typeTwo = TestData.typeTwo();
        DisposalGuideline updated = TestData.typeTwo();

        updated.setName( "updated name" );
        updated.setDescription( "updated description" );

        Mockito.when( repository.existsById( 2L )).thenReturn( true );
        Mockito.when( repository.save( typeTwo )).thenReturn( updated );
        assertThat( service.update( 2L, typeTwo )).isEqualTo( Optional.of( updated ));
    }

    @Test
    public void testUpdateWithInvalidArgs(){
        DisposalGuideline typeTwo = TestData.typeTwo();
        Mockito.when( repository.existsById( 200L )).thenReturn( false );
        assertThat( service.update( 200L, typeTwo )).isEqualTo( Optional.empty() );
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
    */
}
