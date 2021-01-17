package pl.lukaszkutylowski.barapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszkutylowski.barapp.model.Client;

import java.math.BigInteger;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientByNip(String nip);
}
