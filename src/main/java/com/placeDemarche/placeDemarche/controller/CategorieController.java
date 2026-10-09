package com.placeDemarche.placeDemarche.controller;

import com.placeDemarche.placeDemarche.dto.CategorieRequestDto;
import com.placeDemarche.placeDemarche.dto.CategorieResponseDto;
import com.placeDemarche.placeDemarche.service.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Categories.
 */
@RestController
@RequestMapping("/categories")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    /**
     * Retourne la liste complète des entités Categorie.
     *
     * @return La liste des CategorieResponseDto
     */
    @GetMapping
    public List<CategorieResponseDto> getAllCategories() {
        return categorieService.getAllCategories();
    }

    /**
     * Recherche l'entité Categorie par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Categorie recherchée
     * @return L'objet CategorieResponseDto correspondant
     * @throws RuntimeException Si l'entité Categorie n'existe pas
     */
    @GetMapping("/{id}")
    public CategorieResponseDto getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    /**
     * Crée une entité Categorie à partir des données fournies.
     *
     * @param categorieRequest Les données de la requête (CategorieRequestDto)
     * @return L'objet CategorieResponseDto correspondant
     */
    @PostMapping
    public CategorieResponseDto createCategorie(@RequestBody CategorieRequestDto categorieRequest) {
        return categorieService.createCategorie(categorieRequest);
    }

    /**
     * Met à jour l'entité Categorie existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Categorie à modifier
     * @param categorieRequest Les données de la requête (CategorieRequestDto)
     * @return L'objet CategorieResponseDto correspondant
     * @throws RuntimeException Si l'entité Categorie n'existe pas
     */
    @PutMapping("/{id}")
    public CategorieResponseDto updateCategorieById(@PathVariable Long id, @RequestBody CategorieRequestDto categorieRequest) {
        return categorieService.updateCategorieById(id, categorieRequest);
    }

    /**
     * Supprime l'entité Categorie par son identifiant.
     *
     * @param id L'identifiant de l'entité Categorie recherchée
     * @return L'objet CategorieResponseDto correspondant
     * @throws RuntimeException Si l'entité Categorie n'existe pas
     */
    @DeleteMapping("/{id}")
    public CategorieResponseDto deleteCategorieById(@PathVariable Long id) {
        return categorieService.deleteCategorieById(id);
    }
}