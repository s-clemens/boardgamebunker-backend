package nl.novi.clemens.bgbbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import nl.novi.clemens.bgbbackend.payload.request.AllowedGuestsRequest;
import nl.novi.clemens.bgbbackend.repository.CovidRegulationRepository;
import nl.novi.clemens.bgbbackend.service.CovidRegulationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;





@SpringBootTest
@ExtendWith({SpringExtension.class})

class CovidRegulationControllerTest {

    private MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private CovidRegulationServiceImpl covidRegulationService;

    @MockBean
    CovidRegulationRepository covidRegulationRepository;

    Authentication authentication;

    @BeforeEach
    void init(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    @WithMockUser
    void checkNrAllowedGuests() throws Exception {

        // given
        ResponseEntity responseEntity = new ResponseEntity(true, HttpStatus.OK);
        String requestJson =  "{\n" +
                "    \"numberofguests\": 4,\n" +
                "    \"bookingdate\": \"2014-01-04\"\n" +
                "}";

        // when
        when(covidRegulationService.checkNrAllowedGuests(any(AllowedGuestsRequest.class))).thenReturn(responseEntity);

        MvcResult result = mvc.perform(post("/api/covidregulation/user/checkguestsallowed")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();


        //        Then
        assertTrue(content.contains("true"));


    }
}