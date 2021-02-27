package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.payload.request.AllowedGuestsRequest;
import nl.novi.clemens.bgbbackend.payload.request.CovidRegulationRequest;
import nl.novi.clemens.bgbbackend.payload.response.CovidRegulationResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface CovidRegulationService {

    ResponseEntity<MessageResponse> postCovidRegulation (CovidRegulationRequest covidRegulationRequest) ;
    ResponseEntity<MessageResponse> deleteCovidRegulationByID (long id);
    ResponseEntity<MessageResponse> updateCovidRegulationByID(CovidRegulationRequest covidRegulationRequest, long id);
    ResponseEntity<CovidRegulationResponse> findByCovidregulationid(long id);
    ResponseEntity<Boolean> checkNrAllowedGuests (AllowedGuestsRequest allowedGuestsRequest);

}


