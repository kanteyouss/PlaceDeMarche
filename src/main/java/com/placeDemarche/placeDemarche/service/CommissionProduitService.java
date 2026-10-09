package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.CommissionProduitResponseDto;
import com.placeDemarche.placeDemarche.dto.CategorieResponseDto;
import com.placeDemarche.placeDemarche.dto.CommissionResponseDto;
import com.placeDemarche.placeDemarche.entity.CommissionProduit;
import com.placeDemarche.placeDemarche.entity.Categorie;
import com.placeDemarche.placeDemarche.entity.Commission;
import com.placeDemarche.placeDemarche.repository.CommissionProduitRepository;
import com.placeDemarche.placeDemarche.service.CategorieService;
import com.placeDemarche.placeDemarche.service.CommissionService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les CommissionProduits.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class CommissionProduitService {
    private final CommissionProduitRepository commissionProduitRepository;
    private final CategorieService categorieService;
    private final CommissionService commissionService;

    public CommissionProduitService(CommissionProduitRepository commissionProduitRepository, CategorieService categorieService, CommissionService commissionService) {
        this.commissionProduitRepository = commissionProduitRepository;
        this.categorieService = categorieService;
        this.commissionService = commissionService;
    }

    /**
     * Convertit une entité CommissionProduit en DTO de réponse.
     *
     * @param commissionProduit L'entité CommissionProduit à convertir
     * @return L'objet CommissionProduitResponseDto correspondant
     */
    public CommissionProduitResponseDto toDto(CommissionProduit commissionProduit) {
        CommissionProduitResponseDto dto = new CommissionProduitResponseDto();
        dto.setId(commissionProduit.getId());
        dto.setTaux(commissionProduit.getTaux());
        dto.setDateDebut(commissionProduit.getDateDebut());
        dto.setDateFin(commissionProduit.getDateFin());
        if (commissionProduit.getCategorie() != null) {
            dto.setCategorie(categorieService.toDto(commissionProduit.getCategorie()));
        }
        if (commissionProduit.getCommission() != null) {
            dto.setCommission(commissionService.toDto(commissionProduit.getCommission()));
        }
        return dto;
    }
}