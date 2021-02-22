package nl.novi.clemens.bgbbackend.controller;


import nl.novi.clemens.bgbbackend.payload.request.LoginRequest;
import nl.novi.clemens.bgbbackend.payload.request.SignupRequest;
//test

import nl.novi.clemens.bgbbackend.payload.response.JwtResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.service.AuthorizationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Uitleg over CrossOrigin en CORS:
 * https://medium.com/@baphemot/understanding-cors-18ad6b478e2b
 *
 * Gebruik in Spring-boot (op controller en globally)
 * https://www.tutorialspoint.com/spring_boot/spring_boot_cors_support.htm
 *
 * Zoals je hieronder ziet, kun je ook op klasse-niveau een adres configureren. Iaw alle methodes hieronder, hebben
 * /api/auth voor de link staan.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        return authorizationService.registerUser(signUpRequest);
    }

    //test
//    @PostMapping("/token-check")
//    public ResponseEntity<JwtResponse> authenticateUserByToken(@RequestBody TokenRequest tokenRequest) {
//        return authorizationService.authenticateUserByToken(tokenRequest);
//    }

}

