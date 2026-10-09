package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.ClientRequestDto;
import com.placeDemarche.placeDemarche.dto.ClientResponseDto;
import com.placeDemarche.placeDemarche.entity.Client;
import com.placeDemarche.placeDemarche.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier gérant les Clients.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Construit une entité Client à partir des données de la requête.
     *
     * @param clientRequest Les données de la requête (ClientRequestDto)
     * @return L'entité Client construite
     */
    public Client toEntity(ClientRequestDto clientRequest) {
        Client client = new Client();
        client.setNom(clientRequest.getNom());
        client.setCode(clientRequest.getCode());
        client.setEmail(clientRequest.getEmail());
        client.setAdresse(clientRequest.getAdresse());
        return client;
    }

    /**
     * Convertit une entité Client en DTO de réponse.
     *
     * @param client L'entité Client à convertir
     * @return L'objet ClientResponseDto correspondant
     */
    public ClientResponseDto toDto(Client client) {
        ClientResponseDto dto = new ClientResponseDto();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setCode(client.getCode());
        dto.setEmail(client.getEmail());
        dto.setAdresse(client.getAdresse());
        return dto;
    }

    /**
     * Retourne la liste complète des entités Client.
     *
     * @return La liste des ClientResponseDto
     */
    public List<ClientResponseDto> getAllClients() {
        return clientRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Client par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Client recherchée
     * @return L'objet ClientResponseDto correspondant
     * @throws RuntimeException Si l'entité Client n'existe pas
     */
    public ClientResponseDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return toDto(client);
    }

    /**
     * Crée une entité Client à partir des données fournies.
     *
     * @param clientRequest Les données de la requête (ClientRequestDto)
     * @return L'objet ClientResponseDto correspondant
     */
    public ClientResponseDto createClient(ClientRequestDto clientRequest) {
        Client client = toEntity(clientRequest);
        return toDto(clientRepository.save(client));
    }

    /**
     * Met à jour l'entité Client existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Client à modifier
     * @param clientRequest Les données de la requête (ClientRequestDto)
     * @return L'objet ClientResponseDto correspondant
     * @throws RuntimeException Si l'entité Client n'existe pas
     */
    public ClientResponseDto updateClientById(Long id, ClientRequestDto clientRequest) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        client.setNom(clientRequest.getNom());
        client.setCode(clientRequest.getCode());
        client.setEmail(clientRequest.getEmail());
        client.setAdresse(clientRequest.getAdresse());
        return toDto(clientRepository.save(client));
    }

    /**
     * Supprime l'entité Client par son identifiant.
     *
     * @param id L'identifiant de l'entité Client recherchée
     * @return L'objet ClientResponseDto correspondant
     * @throws RuntimeException Si l'entité Client n'existe pas
     */
    public ClientResponseDto deleteClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        clientRepository.deleteById(id);
        return toDto(client);
    }
}