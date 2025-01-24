package com.enviro.assessment.grad001.mondeanna.integration.controller;

import com.enviro.assessment.grad001.mondeanna.model.Category;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@DirtiesContext( classMode = ClassMode.BEFORE_EACH_TEST_METHOD )
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    private final String requestMapping = "/api/v1/categories";

    @Test
    public void testIntegrationOfFindAll() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        List<Category> responseRepository = deserializeRepository( response );

        assertThat( responseRepository.get( 0 ).getId() ).isEqualTo( 1 );
        assertThat( responseRepository.get( 1 ).getName() ).isEqualTo( "Type 1" );
        assertThat( responseRepository.get( 2 ).getDescription() ).contains( "(LCT1 < LC <= LCT2 or TC <= TCT1)" );
    }

    @Test
    public void testIntegrationOfFindById() throws Exception {
        MockHttpServletResponse response = mockMvc.perform( get( requestMapping + "/4" ))
                .andExpect( status().isOk() )
                .andReturn().getResponse();

        Category category = deserializeCategory( response );

        assertThat( category.getId() ).isEqualTo( 4 );
        assertThat( category.getName() ).isEqualTo( "Type 3");
        assertThat( category.getDescription() ).contains( "(LCT0 < LC <= LCT1 or TC <= TCT1)" );
    }

    private List<Category> deserializeRepository(MockHttpServletResponse response ) throws UnsupportedEncodingException, JsonProcessingException {
        return objectMapper.readValue( response.getContentAsString(), new TypeReference<>(){} );
    }

    private Category deserializeCategory(MockHttpServletResponse response ) throws UnsupportedEncodingException, JsonProcessingException {
        return objectMapper.readValue( response.getContentAsString(), Category.class );
    }
}
