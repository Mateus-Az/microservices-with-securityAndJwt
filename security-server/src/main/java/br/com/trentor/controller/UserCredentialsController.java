package br.com.trentor.controller;

import br.com.trentor.model.UserCredential;
import br.com.trentor.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserCredentialsController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String newUser(@RequestBody UserCredential user){
        return authService.saveUser(user);
    }

    @GetMapping("token")
    public String getToken(@RequestBody UserCredential userCredential){
        return authService.generateToken(userCredential.getName());
    }

    @GetMapping("token")
    public void validToken(@RequestParam String token){
        authService.validateToken(token);
    }
}
