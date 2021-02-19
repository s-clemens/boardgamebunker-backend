package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.BoardgameType;
import nl.novi.clemens.bgbbackend.domain.CovidRegulation;
import nl.novi.clemens.bgbbackend.payload.request.CovidRegulationRequest;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.repository.BoardgameTypeRepository;
import nl.novi.clemens.bgbbackend.repository.CovidRegulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TestService {

    @Autowired
    BoardgameTypeRepository boardgameTypeRepository;

    @Autowired
    CovidRegulationRepository covidRegulationRepository;

    public String generatePublicContent() {
        return "Public Content.";
    }


    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String generateUserContent() {
        return "User Content.";
    }
    public List<BoardgameType> generateBoardgameTypeContent() {
        return boardgameTypeRepository.findAll();
    }


    @PreAuthorize("hasRole('MODERATOR')")
    public String generateModContent() {
        return "Moderator Board.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "Admin Board.";
    }

    // MOVE TO CovidRegulationService
    public String postCovidRegulation(CovidRegulationRequest covidRegulationRequest) {

        //Check if dates are valid
        LocalDate todayDate = LocalDate.now();

        if (todayDate.isAfter(covidRegulationRequest.getStartdate())) {
            return "Covid regulationw was not added because the starting date is before today.";
        }
        if (todayDate.isAfter(covidRegulationRequest.getStartdate())) {
            return "Covid regulation was not added because the ending date is before today.";
        }

        // check if already exists or other problems
        // XXXXXXXXXXXXXXXXXXXXXX


        //X XXXXXXXXXXXXXXXXXXXXX




        CovidRegulation covidRegulation = new CovidRegulation(
                covidRegulationRequest.getNrallowedguests(),
                covidRegulationRequest.getStartdate(),
                covidRegulationRequest.getEnddate());

        covidRegulationRepository.save(covidRegulation);

        return "Covid regulation added succesfully!";

    }


}
