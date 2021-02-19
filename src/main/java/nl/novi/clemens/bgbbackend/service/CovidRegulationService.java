package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.payload.request.CovidRegulationRequest;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface CovidRegulationService {

    ResponseEntity<MessageResponse> postCovidRegulation (CovidRegulationRequest covidRegulationRequest) ;
    ResponseEntity<MessageResponse> deleteCovidRegulationByID (long id);
}


