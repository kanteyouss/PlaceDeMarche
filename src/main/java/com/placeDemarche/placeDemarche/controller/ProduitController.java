package com.placeDemarche.placeDemarche.controller;

import com.placeDemarche.placeDemarche.dto.ProduitRequestDto;
import com.placeDemarche.placeDemarche.dto.ProduitResponseDto;
import com.placeDemarche.placeDemarche.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Produits.
 */
@RestController
@RequestMapping("/produits")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    /**
     * Retourne la liste complète des entités Produit.
     *
     * @return La liste des ProduitResponseDto
     */
    @GetMapping
    public List<ProduitResponseDto> getAllProduits() {
        return produitService.getAllProduits();
    }

    /**
     * Recherche l'entité Produit par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Produit recherchée
     * @return L'objet ProduitResponseDto correspondant
     * @throws RuntimeException Si l'entité Produit n'existe pas
     */
    @GetMapping("/{id}")
    public ProduitResponseDto getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    /**
     * Crée une entité Produit à partir des données fournies.
     *
     * @param produitRequest Les données de la requête (ProduitRequestDto)
     * @return L'objet ProduitResponseDto correspondant
     */
    @PostMapping
    public ProduitResponseDto createProduit(@RequestBody ProduitRequestDto produitRequest) {
        return produitService.createProduit(produitRequest);
    }

    /**
     * Met à jour l'entité Produit existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Produit à modifier
     * @param produitRequest Les données de la requête (ProduitRequestDto)
     * @return L'objet ProduitResponseDto correspondant
     * @throws RuntimeException Si l'entité Produit n'existe pas
     */
    @PutMapping("/{id}")
    public ProduitResponseDto updateProduitById(@PathVariable Long id, @RequestBody ProduitRequestDto produitRequest) {
        return produitService.updateProduitById(id, produitRequest);
    }

    /**
     * Supprime l'entité Produit par son identifiant.
     *
     * @param id L'identifiant de l'entité Produit recherchée
     * @return L'objet ProduitResponseDto correspondant
     * @throws RuntimeException Si l'entité Produit n'existe pas
     */
    @DeleteMapping("/{id}")
    public ProduitResponseDto deleteProduitById(@PathVariable Long id) {
        return produitService.deleteProduitById(id);
    }
}