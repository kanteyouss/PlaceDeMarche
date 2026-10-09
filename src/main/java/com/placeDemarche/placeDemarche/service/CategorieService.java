package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.CategorieRequestDto;
import com.placeDemarche.placeDemarche.dto.CategorieResponseDto;
import com.placeDemarche.placeDemarche.entity.Categorie;
import com.placeDemarche.placeDemarche.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier gérant les Categories.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    /**
     * Construit une entité Categorie à partir des données de la requête.
     *
     * @param categorieRequest Les données de la requête (CategorieRequestDto)
     * @return L'entité Categorie construite
     */
    public Categorie toEntity(CategorieRequestDto categorieRequest) {
        Categorie categorie = new Categorie();
        categorie.setLibelle(categorieRequest.getLibelle());
        categorie.setDescription(categorieRequest.getDescription());
        return categorie;
    }

    /**
     * Convertit une entité Categorie en DTO de réponse.
     *
     * @param categorie L'entité Categorie à convertir
     * @return L'objet CategorieResponseDto correspondant
     */
    public CategorieResponseDto toDto(Categorie categorie) {
        CategorieResponseDto dto = new CategorieResponseDto();
        dto.setId(categorie.getId());
        dto.setLibelle(categorie.getLibelle());
        dto.setDescription(categorie.getDescription());
        return dto;
    }

    /**
     * Retourne la liste complète des entités Categorie.
     *
     * @return La liste des CategorieResponseDto
     */
    public List<CategorieResponseDto> getAllCategories() {
        return categorieRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Categorie par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Categorie recherchée
     * @return L'objet CategorieResponseDto correspondant
     * @throws RuntimeException Si l'entité Categorie n'existe pas
     */
    public CategorieResponseDto getCategorieById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvé"));
        return toDto(categorie);
    }

    /**
     * Crée une entité Categorie à partir des données fournies.
     *
     * @param categorieRequest Les données de la requête (CategorieRequestDto)
     * @return L'objet CategorieResponseDto correspondant
     */
    public CategorieResponseDto createCategorie(CategorieRequestDto categorieRequest) {
        Categorie categorie = toEntity(categorieRequest);
        return toDto(categorieRepository.save(categorie));
    }

    /**
     * Met à jour l'entité Categorie existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Categorie à modifier
     * @param categorieRequest Les données de la requête (CategorieRequestDto)
     * @return L'objet CategorieResponseDto correspondant
     * @throws RuntimeException Si l'entité Categorie n'existe pas
     */
    public CategorieResponseDto updateCategorieById(Long id, CategorieRequestDto categorieRequest) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvé"));
        categorie.setLibelle(categorieRequest.getLibelle());
        categorie.setDescription(categorieRequest.getDescription());
        return toDto(categorieRepository.save(categorie));
    }

    /**
     * Supprime l'entité Categorie par son identifiant.
     *
     * @param id L'identifiant de l'entité Categorie recherchée
     * @return L'objet CategorieResponseDto correspondant
     * @throws RuntimeException Si l'entité Categorie n'existe pas
     */
    public CategorieResponseDto deleteCategorieById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvé"));
        categorieRepository.deleteById(id);
        return toDto(categorie);
    }
}