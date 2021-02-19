package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.CovidRegulation;
import nl.novi.clemens.bgbbackend.payload.request.CovidRegulationRequest;
import nl.novi.clemens.bgbbackend.payload.response.CovidRegulationResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.repository.CovidRegulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidRegulationServiceImpl implements CovidRegulationService {

    private CovidRegulationRepository covidRegulationRepository;

    @Autowired
    public void setCovidRegulationRepository(CovidRegulationRepository covidRegulationRepository) {
        this.covidRegulationRepository = covidRegulationRepository;
    }

    // Checks whether dates interfere with already existing regulations.
    private Boolean areDatesValid(LocalDate startdate, LocalDate enddate, List<CovidRegulation> existingRegulations){

        Boolean isValid = true;

        for(int i = 0; i < existingRegulations.size(); i++){
            LocalDate existingstartdate = existingRegulations.get(i).getStartDate();
            LocalDate existingenddate = existingRegulations.get(i).getEndDate();
            if (enddate.isBefore(existingenddate) && startdate.isAfter(existingstartdate)){
                isValid = false;
                break;
            }
            if (enddate.isAfter(existingstartdate) && startdate.isBefore(existingstartdate)){
                isValid = false;
                break;
            }
            if (enddate.isAfter(existingenddate) && startdate.isBefore(existingenddate)){
                isValid = false;
                break;
            }
            if (enddate.isEqual(existingenddate) && startdate.isEqual(existingstartdate)){
                isValid = false;
                break;
            }
            if (enddate.isEqual(existingenddate) || enddate.isEqual(existingstartdate) ||
                    startdate.isEqual(existingstartdate) || startdate.isEqual(existingenddate)){
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    @Override
    public ResponseEntity<MessageResponse> postCovidRegulation(CovidRegulationRequest covidRegulationRequest) {

        //Check if selected dates are not interfering with each other.
        LocalDate todayDate = LocalDate.now();

        if (todayDate.isAfter(covidRegulationRequest.getStartdate())) {
            return ResponseEntity.ok(new MessageResponse("Covid regulation was not added because the starting date is before today."));
        }
        if (todayDate.isAfter(covidRegulationRequest.getStartdate())) {
            return ResponseEntity.ok(new MessageResponse("Covid regulation was not added because the ending date is before today."));
        }
        if (covidRegulationRequest.getEnddate().isBefore(covidRegulationRequest.getStartdate())) {
            return ResponseEntity.ok(new MessageResponse("Covid regulation was not added because the ending date is before the starting date."));
        }

        // Check if selected dates are not interfering with already existing dates.
        if (!areDatesValid(covidRegulationRequest.getStartdate(), covidRegulationRequest.getEnddate(), covidRegulationRepository.findAll())){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "There already is a regulation that overlaps with your selection of dates.");
        }

        CovidRegulation covidRegulation = new CovidRegulation(
                covidRegulationRequest.getNrallowedguests(),
                covidRegulationRequest.getStartdate(),
                covidRegulationRequest.getEnddate());

        covidRegulationRepository.save(covidRegulation);

        return ResponseEntity.ok(new MessageResponse("Covid regulation added successfully!"));
    }

    public ResponseEntity<CovidRegulationResponse> findByCovidregulationid(long id){
        try {
            CovidRegulation regulationMatch = covidRegulationRepository.findByCovidregulationid(id);

            return ResponseEntity.ok(new CovidRegulationResponse(
                    regulationMatch.getCovidregulationid(),
                    regulationMatch.getNrAllowedGuests(),
                    regulationMatch.getStartDate(),
                    regulationMatch.getEndDate()
            ));
        } catch (Exception e) {
//            throw new ResponseEntity.ok(new MessageResponse("Something went wrong with your request."));
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Covid Regulation not found", e);
        }

    }

    @Override
    public ResponseEntity<MessageResponse> deleteCovidRegulationByID(long id){

        if (covidRegulationRepository.existsById(id)) {
            covidRegulationRepository.deleteById(id);
            return  ResponseEntity.ok(new MessageResponse("The covid regulation with ID: " + id + " was deleted."));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A matching covid regulation with given id (" + id + ") was not found.");
        }
    }

    public ResponseEntity<MessageResponse> updateCovidRegulationByID(CovidRegulationRequest covidRegulationRequest, long id){
        if (covidRegulationRepository.existsById(id)) {
            CovidRegulation covidRegulation = covidRegulationRepository.findByCovidregulationid(id);

            covidRegulation.setNrAllowedGuests(covidRegulationRequest.getNrallowedguests());
            covidRegulation.setStartDate(covidRegulationRequest.getStartdate());
            covidRegulation.setEndDate(covidRegulationRequest.getEnddate());

            covidRegulationRepository.save(covidRegulation);

            return ResponseEntity.ok(new MessageResponse("The covid regulation with ID: " + id + " was updated."));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A matching covid regulation with given id (" + id + ") was not found.");
        }
    }

}


