package com.placeDemarche.placeDemarche.controller;

import com.placeDemarche.placeDemarche.dto.CommandeRequestDto;
import com.placeDemarche.placeDemarche.dto.CommandeResponseDto;
import com.placeDemarche.placeDemarche.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Commandes.
 */
@RestController
@RequestMapping("/commandes")
public class CommandeController {
    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    /**
     * Retourne la liste complète des entités Commande.
     *
     * @return La liste des CommandeResponseDto
     */
    @GetMapping
    public List<CommandeResponseDto> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    /**
     * Recherche l'entité Commande par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Commande recherchée
     * @return L'objet CommandeResponseDto correspondant
     * @throws RuntimeException Si l'entité Commande n'existe pas
     */
    @GetMapping("/{id}")
    public CommandeResponseDto getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    /**
     * Crée une entité Commande à partir des données fournies.
     *
     * @param commandeRequest Les données de la requête (CommandeRequestDto)
     * @return L'objet CommandeResponseDto correspondant
     */
    @PostMapping
    public CommandeResponseDto createCommande(@RequestBody CommandeRequestDto commandeRequest) {
        return commandeService.createCommande(commandeRequest);
    }

    /**
     * Met à jour l'entité Commande existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Commande à modifier
     * @param commandeRequest Les données de la requête (CommandeRequestDto)
     * @return L'objet CommandeResponseDto correspondant
     * @throws RuntimeException Si l'entité Commande n'existe pas
     */
    @PutMapping("/{id}")
    public CommandeResponseDto updateCommandeById(@PathVariable Long id, @RequestBody CommandeRequestDto commandeRequest) {
        return commandeService.updateCommandeById(id, commandeRequest);
    }

    /**
     * Supprime l'entité Commande par son identifiant.
     *
     * @param id L'identifiant de l'entité Commande recherchée
     * @return L'objet CommandeResponseDto correspondant
     * @throws RuntimeException Si l'entité Commande n'existe pas
     */
    @DeleteMapping("/{id}")
    public CommandeResponseDto deleteCommandeById(@PathVariable Long id) {
        return commandeService.deleteCommandeById(id);
    }
}