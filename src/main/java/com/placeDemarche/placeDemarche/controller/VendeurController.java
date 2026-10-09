package com.placeDemarche.placeDemarche.controller;

import com.placeDemarche.placeDemarche.dto.VendeurRequestDto;
import com.placeDemarche.placeDemarche.dto.VendeurResponseDto;
import com.placeDemarche.placeDemarche.service.VendeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Vendeurs.
 */
@RestController
@RequestMapping("/vendeurs")
public class VendeurController {
    private final VendeurService vendeurService;

    public VendeurController(VendeurService vendeurService) {
        this.vendeurService = vendeurService;
    }

    /**
     * Retourne la liste complète des entités Vendeur.
     *
     * @return La liste des VendeurResponseDto
     */
    @GetMapping
    public List<VendeurResponseDto> getAllVendeurs() {
        return vendeurService.getAllVendeurs();
    }

    /**
     * Recherche l'entité Vendeur par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Vendeur recherchée
     * @return L'objet VendeurResponseDto correspondant
     * @throws RuntimeException Si l'entité Vendeur n'existe pas
     */
    @GetMapping("/{id}")
    public VendeurResponseDto getVendeurById(@PathVariable Long id) {
        return vendeurService.getVendeurById(id);
    }

    /**
     * Crée une entité Vendeur à partir des données fournies.
     *
     * @param vendeurRequest Les données de la requête (VendeurRequestDto)
     * @return L'objet VendeurResponseDto correspondant
     */
    @PostMapping
    public VendeurResponseDto createVendeur(@RequestBody VendeurRequestDto vendeurRequest) {
        return vendeurService.createVendeur(vendeurRequest);
    }

    /**
     * Met à jour l'entité Vendeur existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Vendeur à modifier
     * @param vendeurRequest Les données de la requête (VendeurRequestDto)
     * @return L'objet VendeurResponseDto correspondant
     * @throws RuntimeException Si l'entité Vendeur n'existe pas
     */
    @PutMapping("/{id}")
    public VendeurResponseDto updateVendeurById(@PathVariable Long id, @RequestBody VendeurRequestDto vendeurRequest) {
        return vendeurService.updateVendeurById(id, vendeurRequest);
    }

    /**
     * Supprime l'entité Vendeur par son identifiant.
     *
     * @param id L'identifiant de l'entité Vendeur recherchée
     * @return L'objet VendeurResponseDto correspondant
     * @throws RuntimeException Si l'entité Vendeur n'existe pas
     */
    @DeleteMapping("/{id}")
    public VendeurResponseDto deleteVendeurById(@PathVariable Long id) {
        return vendeurService.deleteVendeurById(id);
    }
}