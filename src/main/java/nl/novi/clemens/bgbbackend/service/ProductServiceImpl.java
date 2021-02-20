package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.Boardgame;
import nl.novi.clemens.bgbbackend.domain.BoardgameType;
import nl.novi.clemens.bgbbackend.domain.Consumable;
import nl.novi.clemens.bgbbackend.domain.ConsumableType;
import nl.novi.clemens.bgbbackend.domain.Product;
import nl.novi.clemens.bgbbackend.domain.ProductType;
import nl.novi.clemens.bgbbackend.domain.enums.EBoardgameType;
import nl.novi.clemens.bgbbackend.payload.request.BoardgameRequest;
import nl.novi.clemens.bgbbackend.payload.request.ConsumableRequest;
import nl.novi.clemens.bgbbackend.payload.response.BoardgameResponse;
import nl.novi.clemens.bgbbackend.payload.response.ConsumableResponse;
import nl.novi.clemens.bgbbackend.payload.response.CovidRegulationResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.repository.BoardgameRepository;
import nl.novi.clemens.bgbbackend.repository.BoardgameTypeRepository;
import nl.novi.clemens.bgbbackend.repository.ConsumableRepository;
import nl.novi.clemens.bgbbackend.repository.ConsumableTypeRepository;
import nl.novi.clemens.bgbbackend.repository.ProductRepository;
import nl.novi.clemens.bgbbackend.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    // AutoWires
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ConsumableRepository consumableRepository;
    @Autowired
    private BoardgameRepository boardgameRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ConsumableTypeRepository consumableTypeRepository;
    @Autowired
    private BoardgameTypeRepository boardgameTypeRepository;


    // Methods
    @Override
    public ResponseEntity<MessageResponse> postConsumable(ConsumableRequest consumableRequest) {

        // Check if exists
        if (productRepository.existsByName(consumableRequest.getName())){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Product (name) already exists.");
        }

        // Get Producttype instance
        ProductType producttype = productTypeRepository.findByName(consumableRequest.getProducttype());
        ConsumableType consumabletype = consumableTypeRepository.findByName(consumableRequest.getConsumabletype());


        // Apply to entity
        Product product = new Product(
                consumableRequest.getName(),
                consumableRequest.getPrice(),
                consumableRequest.getCoverimage(),
                producttype
        );
        Consumable consumable = new Consumable(
                consumableRequest.getIngredients(),
                consumabletype
        );
        // Create relation
        product.setConsumable(consumable);
        consumable.setProduct(product);

        // Save to DB
        productRepository.save(product);
        consumableRepository.save(consumable);

        return ResponseEntity.ok(new MessageResponse("The consumable was added!"));
    }

    @Override
    public ResponseEntity<MessageResponse> postBoardgame(BoardgameRequest boardgameRequest) {

        // Check if exists
        if (productRepository.existsByName(boardgameRequest.getName())){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Product (name) already exists.");
        }

        // Get Producttype instance
        ProductType producttype = productTypeRepository.findByName(boardgameRequest.getProducttype());
        BoardgameType boardgametype = boardgameTypeRepository.findByName(boardgameRequest.getBoardgametype());

        // Apply to entity
        Product product = new Product(
                boardgameRequest.getName(),
                boardgameRequest.getPrice(),
                boardgameRequest.getCoverimage(),
                producttype
        );
        Boardgame boardgame = new Boardgame(
                boardgameRequest.getTotalStock(),
                boardgameRequest.getMinplayers(),
                boardgameRequest.getMaxplayers(),
                boardgameRequest.getDescription(),
                boardgametype
        );

        // Create relation
        product.setBoardgame(boardgame);
        boardgame.setProduct(product);

        // Save to DB
        productRepository.save(product);
        boardgameRepository.save(boardgame);

        return ResponseEntity.ok(new MessageResponse("The boardgame was added!"));
    }

    @Override
    public ResponseEntity<BoardgameResponse> getBoardgameById(Long id){
        if (boardgameRepository.existsById(id)){

            Boardgame boardgame = boardgameRepository.findByBoardgameid(id);
            Product product = boardgame.getProduct();
            BoardgameType boardgametype = boardgame.getBoardgametype();

            // Turn enum into string translation
            String gametype = boardgameTypeToString(boardgametype);

            return ResponseEntity.ok(new BoardgameResponse(
                   boardgame.getBoardgameid(),
                   product.getName(),
                   gametype,
                   boardgame.getMinplayers(),
                   boardgame.getMaxplayers(),
                   boardgame.getDescription(),
                   product.getImage_cover(),
                   product.getProduct_price()
            ));
        }else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A matching board game with given id (" + id + ") was not found.");
        }
    }

    @Override
    public ResponseEntity<ConsumableResponse> getConsumableById(Long id){
        if (consumableRepository.existsById(id)){

            Consumable consumable = consumableRepository.findByConsumableid(id);
            Product product = consumable.getProduct();
            ConsumableType consumabletype = consumable.getConsumabletype();

            String consumetype = null;

            // Enum to frontend string
            switch(consumabletype.getName()){
                case FOOD:
                    consumetype = "Eten";
                    break;
                case DRINKS:
                    consumetype = "Drinken";
                    break;
            }

            return ResponseEntity.ok(new ConsumableResponse(
               product.getName(),
               consumetype,
               consumable.getIngredients(),
               product.getImage_cover(),
               product.getProduct_price()
            ));

        }else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A matching consumable with given id (" + id + ") was not found.");
        }
    }

    @Override
    public List<BoardgameResponse> getBoardgames(){

        // Create blank list
        List<BoardgameResponse> boardgames = new ArrayList<BoardgameResponse>();

        // Iterate over all boardgames in column
        List<Boardgame> boardgamelist = boardgameRepository.findAll();

        for(int i= 0; i < boardgamelist.size(); i++){
            // make response
            Boardgame boardgame = boardgamelist.get(i);
            Product product = boardgame.getProduct();
            BoardgameType boardgametype = boardgame.getBoardgametype();

            // Turn enum into string translation
            String gametype = boardgameTypeToString(boardgametype);

            BoardgameResponse response = new BoardgameResponse(
                    boardgame.getBoardgameid(),
                    product.getName(),
                    gametype,
                    boardgame.getMinplayers(),
                    boardgame.getMaxplayers(),
                    boardgame.getDescription(),
                    product.getImage_cover(),
                    product.getProduct_price()
            );
            // Add response to list
            boardgames.add(response);
        }
        // return list
        return boardgames;
    }

    private String boardgameTypeToString(BoardgameType boardgametype){
        String gametype = null;

        switch(boardgametype.getName()){
            case TWO_HOURS:
                gametype = "2 hours";
                break;
            case THIRTY_MINUTES:
                gametype = "30 minutes";
                break;
            case ONE_HOUR:
                gametype = "1 hour";
                break;
        }
        return gametype;
    }
}
