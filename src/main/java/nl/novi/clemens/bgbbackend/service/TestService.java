package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.BoardgameType;
import nl.novi.clemens.bgbbackend.repository.BoardgameTypeRepository;
import nl.novi.clemens.bgbbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    BoardgameTypeRepository boardgameTypeRepository;

    public String generatePublicContent() {
        return "Public Content.";
    }
    public List<BoardgameType> generateBoardgameTypeContent() {
        return boardgameTypeRepository.findAll();
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String generateUserContent() {
        return "User Content.";
    }


    @PreAuthorize("hasRole('MODERATOR')")
    public String generateModContent() {
        return "Moderator Board.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "Admin Board.";
    }



}
