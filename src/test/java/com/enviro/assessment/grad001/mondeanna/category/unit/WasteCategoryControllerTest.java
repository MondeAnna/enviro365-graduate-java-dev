package com.enviro.assessment.grad001.mondeanna.category.unit;

import com.enviro.assessment.grad001.mondeanna.category.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

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
public class WasteCategoryControllerTest {

    @Mock
    private WasteCategoryServices services;

    @InjectMocks
    private WasteCategoryController controller;

    private final List<WasteCategory> mockRepo = TestData.mockWasteCategoryRepo();
    private final WasteCategory typeTwo = TestData.typeTwo();
    private final WasteCategory typeTwenty = TestData.typeTwenty();

    @Test
    public void testSave(){
        URI uri = URI.create( "/api/v1/waste-categories/20" );
        ResponseEntity<URI> expected =  ResponseEntity.created( uri ).build();

        Mockito.when( services.save( typeTwenty )).thenReturn( typeTwenty );
        assertThat( controller.save( typeTwenty )).isEqualTo( expected );
    }

    @Test
    public void testFindAll(){
        Mockito.when( services.findAll() ).thenReturn( mockRepo );
        assertThat( controller.findAll() ).isEqualTo( ResponseEntity.ok( mockRepo ));
    }

    @Test
    public void testFindById(){
        Mockito.when( services.findById( 2L )).thenReturn( Optional.of( typeTwo ));
        assertThat( controller.findById( 2L )).isEqualTo( ResponseEntity.ok( typeTwo ));
    }

    @Test
    public void testFindByIdWithInvalidArg(){
        Mockito.when( services.findById( anyLong() )).thenReturn( Optional.empty() );
        assertThat( controller.findById( 2L )).isEqualTo( ResponseEntity.badRequest().build() );
    }

    @Test
    public void testUpdate(){
        WasteCategory updated = TestData.typeTwo();

        updated.setName( "updated name" );
        updated.setDescription( "updated description" );

        assertThat( typeTwo ).isNotEqualTo( updated );

        Mockito.when( services.update( 2L, typeTwo )).thenReturn( Optional.of( updated ));
        assertThat( controller.update( 2L, typeTwo )).isEqualTo( ResponseEntity.ok( updated ));
    }

    @Test
    public void testUpdateWithInvalidArgs(){
        ResponseEntity<WasteCategory> expected = ResponseEntity.badRequest().build();

        Mockito.when( services.update( anyLong(), any() )).thenReturn( Optional.empty() );
        assertThat( controller.update( 20L, typeTwenty )).isEqualTo( expected );
    }

    @Test
    public void testDeleteWithInvalidArgument(){
        ResponseEntity<String> expected = ResponseEntity.badRequest( ).body( "Invalid Argument" );
        Mockito.when( services.delete( anyLong() )).thenReturn( false );
        assertThat( controller.delete( 1000L )).isEqualTo( expected );
    }

    @Test
    public void testDelete(){
        ResponseEntity<String> expected = ResponseEntity.ok().body( "Waste Category ID of 20 deleted" );
        Mockito.when( services.delete( 20L )).thenReturn( true );
        assertThat( controller.delete( 20L )).isEqualTo( expected );
    }
}
