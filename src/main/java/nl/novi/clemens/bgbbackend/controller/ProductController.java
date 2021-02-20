package nl.novi.clemens.bgbbackend.controller;


import nl.novi.clemens.bgbbackend.domain.Product;
import nl.novi.clemens.bgbbackend.payload.request.BoardgameRequest;
import nl.novi.clemens.bgbbackend.payload.request.ConsumableRequest;
import nl.novi.clemens.bgbbackend.payload.response.BoardgameResponse;
import nl.novi.clemens.bgbbackend.payload.response.ConsumableResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.repository.ProductRepository;
import nl.novi.clemens.bgbbackend.service.ProductServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    // Autowires
    @Autowired
    ProductServiceImpl productServiceImpl;
    @Autowired
    ProductRepository productRepository;

    // Post consumable
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/postconsumable")
    public ResponseEntity<MessageResponse> postConsumable(@RequestBody ConsumableRequest consumableRequest){
        return productServiceImpl.postConsumable(consumableRequest);
    }

    // Post boardgame
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/postboardgame")
    public ResponseEntity<MessageResponse> postBoardgame(@RequestBody BoardgameRequest boardgameRequest){
        return productServiceImpl.postBoardgame(boardgameRequest);
    }

    // Get all products
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // Get product by ID (basic repository object return)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id){
        return productRepository.findByProductid(id);
    }

    // Get boardgame by ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/boardgame/{id}")
    public ResponseEntity<BoardgameResponse> getBoardgameById(@PathVariable Long id){
        return productServiceImpl.getBoardgameById(id);
    }

    // Get consumable by ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/consumable/{id}")
    public ResponseEntity<ConsumableResponse> getConsumableById(@PathVariable Long id){
        return productServiceImpl.getConsumableById(id);
    }

    // Get all boardgames
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/boardgame/all")
    public List<BoardgameResponse> getBoardgames(){
        return productServiceImpl.getBoardgames();
    }

    // Get all consumables

    // Get all drinks

    // Get all foods

    // Update boardgame

    // Update consumable




}
