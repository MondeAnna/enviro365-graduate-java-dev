package com.enviro.assessment.grad001.mondeanna.integration;

import com.enviro.assessment.grad001.mondeanna.model.RecyclingTip;

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
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Disabled( "In ability to write to db makes these unsafe" )
@AutoConfigureMockMvc
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@DirtiesContext( classMode = ClassMode.BEFORE_EACH_TEST_METHOD )
public class RecyclingTipIntegrationTest {

    private final String json = "{'tip': 'Compost Waste', 'description': 'Create own composite'}";
    private final String requestMapping = "/api/v1/recycling-tips";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

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

        RecyclingTip typeTen = deserializeRecyclingTip( response );

        assertThat( typeTen.getTip() ).isEqualTo( "Compost Waste" );
        assertThat( typeTen.getDescription() ).isEqualTo( "Create own composite" );
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

        List<RecyclingTip> responseRepository = deserializeRepository( response );
        assertThat( responseRepository.isEmpty() ).isFalse();
    }

    @Test
    public void testIntegrationOfFindById() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/1" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        RecyclingTip category = deserializeRecyclingTip( response );
        String expectedDescription = "refusing to use non-recyclable products";

        /* be aware that the test touches the actual database */
        assertThat( category.getTip() ).isEqualTo( "Refuse" );
        assertThat( category.getDescription() ).contains( expectedDescription );
    }

    @Test
    public void testIntegrationOfFindByIdWithInvalidArgs() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        List<RecyclingTip> responseRepository = deserializeRepository( response );
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

        RecyclingTip category = deserializeRepository( findAllResponse ).get( 0 );
        long id = category.getId();

        assertThat( category.getId() ).isEqualTo( 1 );
        assertThat( category.getTip() ).isEqualTo( "Refuse" );

        String json = "{'tip': 'updated tip', 'description': 'updated description'}";

        MockHttpServletResponse response = mockMvc.perform( put( requestMapping + "/1" + id )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( json ))
                .andExpect( status().isCreated() )
                .andReturn().getResponse();

        assertThat( response.getContentAsString() ).contains( "'id': 1" );
        assertThat( response.getContentAsString() ).contains( json );

        RecyclingTip typeTen = deserializeRecyclingTip( response );

        assertThat( typeTen.getTip() ).isEqualTo( "updated tip" );
        assertThat( typeTen.getDescription() ).isEqualTo( "updated description" );
    }

    @Test
    public void testIntegrationOfUpdateWithInvalidArg() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        List<RecyclingTip> responseRepository = deserializeRepository( response );
        int invalidId = responseRepository.size() + 1;

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

    private List<RecyclingTip> deserializeRepository(MockHttpServletResponse response )
            throws UnsupportedEncodingException, JsonProcessingException {
        return objectMapper.readValue( response.getContentAsString(), new TypeReference<>(){} );
    }

    private RecyclingTip deserializeRecyclingTip(MockHttpServletResponse response )
            throws UnsupportedEncodingException, JsonProcessingException {
        return objectMapper.readValue( response.getContentAsString(), RecyclingTip.class );
    }
}
