package br.com.trentor.repository;

import br.com.trentor.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCredentialsRepository extends JpaRepository<UserCredential, UUID> {


}
