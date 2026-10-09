package com.placeDemarche.placeDemarche.controller;

import com.placeDemarche.placeDemarche.dto.ClientRequestDto;
import com.placeDemarche.placeDemarche.dto.ClientResponseDto;
import com.placeDemarche.placeDemarche.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Clients.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Retourne la liste complète des entités Client.
     *
     * @return La liste des ClientResponseDto
     */
    @GetMapping
    public List<ClientResponseDto> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * Recherche l'entité Client par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Client recherchée
     * @return L'objet ClientResponseDto correspondant
     * @throws RuntimeException Si l'entité Client n'existe pas
     */
    @GetMapping("/{id}")
    public ClientResponseDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    /**
     * Crée une entité Client à partir des données fournies.
     *
     * @param clientRequest Les données de la requête (ClientRequestDto)
     * @return L'objet ClientResponseDto correspondant
     */
    @PostMapping
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequest) {
        return clientService.createClient(clientRequest);
    }

    /**
     * Met à jour l'entité Client existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Client à modifier
     * @param clientRequest Les données de la requête (ClientRequestDto)
     * @return L'objet ClientResponseDto correspondant
     * @throws RuntimeException Si l'entité Client n'existe pas
     */
    @PutMapping("/{id}")
    public ClientResponseDto updateClientById(@PathVariable Long id, @RequestBody ClientRequestDto clientRequest) {
        return clientService.updateClientById(id, clientRequest);
    }

    /**
     * Supprime l'entité Client par son identifiant.
     *
     * @param id L'identifiant de l'entité Client recherchée
     * @return L'objet ClientResponseDto correspondant
     * @throws RuntimeException Si l'entité Client n'existe pas
     */
    @DeleteMapping("/{id}")
    public ClientResponseDto deleteClientById(@PathVariable Long id) {
        return clientService.deleteClientById(id);
    }
}