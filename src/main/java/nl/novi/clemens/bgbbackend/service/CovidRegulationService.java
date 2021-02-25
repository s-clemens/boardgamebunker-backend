package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.CovidRegulation;
import nl.novi.clemens.bgbbackend.payload.request.AllowedGuestsRequest;
import nl.novi.clemens.bgbbackend.payload.request.CovidRegulationRequest;
import nl.novi.clemens.bgbbackend.payload.response.CovidRegulationResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CovidRegulationService {

    ResponseEntity<MessageResponse> postCovidRegulation (CovidRegulationRequest covidRegulationRequest) ;
    ResponseEntity<MessageResponse> deleteCovidRegulationByID (long id);
    ResponseEntity<MessageResponse> updateCovidRegulationByID(CovidRegulationRequest covidRegulationRequest, long id);
    ResponseEntity<CovidRegulationResponse> findByCovidregulationid(long id);
    ResponseEntity<Boolean> checkNrAllowedGuests (AllowedGuestsRequest allowedGuestsRequest);

}


