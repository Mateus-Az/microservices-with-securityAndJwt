package br.com.trentor.service;

import br.com.trentor.model.UserCredential;
import br.com.trentor.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserCredentialsRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserCredential credential){
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "";
    }

    public String generateToken(String username){
    return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
