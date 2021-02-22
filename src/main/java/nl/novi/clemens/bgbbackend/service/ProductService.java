package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.payload.request.BoardgameRequest;
import nl.novi.clemens.bgbbackend.payload.request.ConsumableRequest;
import nl.novi.clemens.bgbbackend.payload.response.BoardgameResponse;
import nl.novi.clemens.bgbbackend.payload.response.ConsumableResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ResponseEntity<MessageResponse> postConsumable (ConsumableRequest consumableRequest);
    ResponseEntity<MessageResponse> postBoardgame (BoardgameRequest boardgameRequest);
    ResponseEntity<BoardgameResponse> getBoardgameById (Long id);
    ResponseEntity<ConsumableResponse> getConsumableById (Long id);
    List<BoardgameResponse> getBoardgames();
    List<ConsumableResponse> getConsumablesSortedOnType();
    ResponseEntity<MessageResponse> updateBoardgameById (BoardgameRequest boardgameRequest, Long id);
    ResponseEntity<MessageResponse> updateConsumableById (ConsumableRequest consumableRequest, Long id);

}
