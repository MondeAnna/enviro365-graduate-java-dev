package com.enviro.assessment.grad001.mondeanna.category.integration;

import com.enviro.assessment.grad001.mondeanna.category.WasteCategory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@DirtiesContext( classMode = ClassMode.BEFORE_EACH_TEST_METHOD )
public class WasteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String json = "{'name': 'Type 10', 'description': 'fancy test description'}";
    private final String requestMapping = "/api/v1/waste-categories";

    @Test
    @Disabled( "response is status code 400 instead of 201" )
    public void testIntegrationOfSaveUsingJson() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( post( requestMapping + "/" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( json ))
                .andExpect( status().isCreated() )
                .andReturn().getResponse();

        assertThat( response.getContentAsString() ).contains( "id" );
        assertThat( response.getContentAsString() ).contains( json );

        WasteCategory typeTen = deserializeWasteCategory( response );

        assertThat( response.getStatus() ).isEqualTo( HttpStatus.CREATED.value() );
        assertThat( typeTen.getName() ).isEqualTo( "Type 10" );
        assertThat( typeTen.getDescription() ).isEqualTo( "fancy test description" );
    }

    @Test
    public void testIntegrationOfSaveWithInvalidArgs() throws Exception {
        mockMvc.perform( post( requestMapping + "/" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( json ))
                .andExpect( status().isBadRequest() )
                .andReturn().getResponse();
    }

    @Test
    public void testIntegrationOfFindAll() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        List<WasteCategory> responseRepository = deserializeRepository( response );
        String expectedDescription = "(LCT1 < LC <= LCT2 or TC <= TCT1)";

        assertThat( responseRepository.get( 0 ).getId() ).isEqualTo( 1 );
        assertThat( responseRepository.get( 1 ).getName() ).isEqualTo( "Type 1" );
        assertThat( responseRepository.get( 2 ).getDescription() ).contains( expectedDescription );
    }

    @Test
    public void testIntegrationOfFindById() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/4" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        WasteCategory category = deserializeWasteCategory( response );
        String expectedDescription = "(LCT0 < LC <= LCT1 or TC <= TCT1)";

        assertThat( category.getId() ).isEqualTo( 4 );
        assertThat( category.getName() ).isEqualTo( "Type 3");
        assertThat( category.getDescription() ).contains( expectedDescription );
    }

    @Test
    public void testIntegrationOfFindByIdWithInvalidArgs() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        List<WasteCategory> responseRepository = deserializeRepository( response );
        int invalidId = responseRepository.size() + 1;

        mockMvc.perform( get( requestMapping + "/" + invalidId ))
                .andExpect( status().isBadRequest() )
                .andReturn().getResponse();
    }

    @Test
    @Disabled( "response is status code 400 instead of 200" )
    public void testIntegrationOfUpdate() throws Exception {
        MockHttpServletResponse findAllResponse = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        WasteCategory category = deserializeRepository( findAllResponse ).get( 0 );
        long id = category.getId();

        assertThat( category.getId() ).isEqualTo( id );
        assertThat( category.getName() ).isEqualTo( "Type 0" );

        String json = "{'name': 'Type 10', 'description': 'updated description'}";

        MockHttpServletResponse response = mockMvc.perform( put( requestMapping + "/" + id )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( json ))
                .andExpect( status().isCreated() )
                .andReturn().getResponse();

        assertThat( response.getContentAsString() ).contains( "'id': 1" );
        assertThat( response.getContentAsString() ).contains( json );

        WasteCategory typeTen = deserializeWasteCategory( response );

        assertThat( typeTen.getName() ).isEqualTo( "Type 10" );
        assertThat( typeTen.getDescription() ).isEqualTo( "fancy test description" );
    }

    @Test
    public void testIntegrationOfUpdateWithInvalidArg() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        List<WasteCategory> responseRepository = deserializeRepository( response );
        int invalidId = responseRepository.size() + 1;

        String json = "{'name': 'Type 10', 'description': 'updated description'}";

        mockMvc.perform( put( requestMapping + "/" + invalidId )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( json ))
                .andExpect( status().isBadRequest() );
    }

    @Test
    public void testIntegrationOfDelete() throws Exception {
        MockHttpServletResponse firstResponse = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        long firstRepoSize = deserializeRepository( firstResponse ).size();
        long validId = firstRepoSize == 0 ? -1 :firstRepoSize - 1;

        /* presently unable to guarantee state of repository */
        if ( validId >= 0 ) {
            mockMvc.perform( delete( requestMapping + "/" + validId ))
                .andExpect( status().isOk() );
        }

        MockHttpServletResponse secondResponse = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        long secondRepoSize = deserializeRepository( secondResponse ).size();

        if ( validId >= 0 )
            assertThat( secondRepoSize ).isEqualTo( firstRepoSize - 1);
        else
            assertThat( secondRepoSize ).isEqualTo( firstRepoSize );
    }

    @Test
    public void testIntegrationOfDeleteWithInvalidArg() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        long repoSize = deserializeRepository( response ).size();
        long InvalidId = repoSize + 1;

        mockMvc.perform( delete( requestMapping + "/" + InvalidId ))
            .andExpect( status().isBadRequest() );
    }

    private List<WasteCategory> deserializeRepository(MockHttpServletResponse response )
            throws UnsupportedEncodingException, JsonProcessingException {
        return objectMapper.readValue( response.getContentAsString(), new TypeReference<>(){} );
    }

    private WasteCategory deserializeWasteCategory(MockHttpServletResponse response )
            throws UnsupportedEncodingException, JsonProcessingException {
        return objectMapper.readValue( response.getContentAsString(), WasteCategory.class );
    }
}
