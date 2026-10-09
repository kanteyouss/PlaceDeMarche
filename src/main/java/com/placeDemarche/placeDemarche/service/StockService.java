package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.StockResponseDto;
import com.placeDemarche.placeDemarche.dto.ProduitVariantResponseDto;
import com.placeDemarche.placeDemarche.dto.EntrepotResponseDto;
import com.placeDemarche.placeDemarche.entity.Stock;
import com.placeDemarche.placeDemarche.entity.ProduitVariant;
import com.placeDemarche.placeDemarche.entity.Entrepot;
import com.placeDemarche.placeDemarche.repository.StockRepository;
import com.placeDemarche.placeDemarche.service.ProduitVariantService;
import com.placeDemarche.placeDemarche.service.EntrepotService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Stocks.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class StockService {
    private final StockRepository stockRepository;
    private final ProduitVariantService produitVariantService;
    private final EntrepotService entrepotService;

    public StockService(StockRepository stockRepository, ProduitVariantService produitVariantService, EntrepotService entrepotService) {
        this.stockRepository = stockRepository;
        this.produitVariantService = produitVariantService;
        this.entrepotService = entrepotService;
    }

    /**
     * Convertit une entité Stock en DTO de réponse.
     *
     * @param stock L'entité Stock à convertir
     * @return L'objet StockResponseDto correspondant
     */
    public StockResponseDto toDto(Stock stock) {
        StockResponseDto dto = new StockResponseDto();
        dto.setId(stock.getId());
        dto.setQuantite(stock.getQuantite());
        if (stock.getProduitVariant() != null) {
            dto.setProduitVariant(produitVariantService.toDto(stock.getProduitVariant()));
        }
        if (stock.getEntrepot() != null) {
            dto.setEntrepot(entrepotService.toDto(stock.getEntrepot()));
        }
        return dto;
    }
}