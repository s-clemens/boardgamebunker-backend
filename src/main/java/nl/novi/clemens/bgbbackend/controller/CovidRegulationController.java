package nl.novi.clemens.bgbbackend.controller;

import nl.novi.clemens.bgbbackend.domain.CovidRegulation;
import nl.novi.clemens.bgbbackend.payload.request.AllowedGuestsRequest;
import nl.novi.clemens.bgbbackend.payload.request.CovidRegulationRequest;
import nl.novi.clemens.bgbbackend.payload.response.CovidRegulationResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.repository.CovidRegulationRepository;
import nl.novi.clemens.bgbbackend.service.CovidRegulationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/covidregulation")
public class CovidRegulationController {

    @Autowired
    CovidRegulationServiceImpl covidRegulationService;

    @Autowired
    CovidRegulationRepository covidRegulationRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/postcovidregulation")
    public ResponseEntity<MessageResponse> postCovidRegulation(@RequestBody CovidRegulationRequest covidRegulationRequest) {
        return covidRegulationService.postCovidRegulation(covidRegulationRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletecovidregulation/{id}")
    public ResponseEntity<MessageResponse> deleteCovidRegulationByID(@PathVariable long id) {
        return covidRegulationService.deleteCovidRegulationByID(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getcovidregulation/all")
    public List<CovidRegulation> getAllCovidRegulation() {
        return covidRegulationRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getcovidregulation/{id}")
    public ResponseEntity<CovidRegulationResponse> getCovidRegulationByID(@PathVariable long id) {
        return covidRegulationService.findByCovidregulationid(id);
    }

    // Update regulation
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/updatecovidregulation/{id}")
    public ResponseEntity<MessageResponse> updateCovidRegulationByID(@RequestBody CovidRegulationRequest covidRegulationRequest, @PathVariable long id) {
        return covidRegulationService.updateCovidRegulationByID(covidRegulationRequest, id);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/checkguestsallowed")
    public ResponseEntity<Boolean> checkNrAllowedGuests(@RequestBody AllowedGuestsRequest allowedGuestsRequest){
        return covidRegulationService.checkNrAllowedGuests(allowedGuestsRequest);
    }

}
