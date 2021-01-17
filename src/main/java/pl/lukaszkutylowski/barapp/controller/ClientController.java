package pl.lukaszkutylowski.barapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszkutylowski.barapp.dao.ClientRepository;
import pl.lukaszkutylowski.barapp.model.Client;

@RestController
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/client")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @GetMapping("/client/:id")
    public ResponseEntity<Client> getClientById(@RequestParam Long id) {
        return ResponseEntity.ok(clientRepository.findById(id).get());
    }
}
