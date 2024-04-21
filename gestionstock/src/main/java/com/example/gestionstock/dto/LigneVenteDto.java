package com.example.gestionstock.dto;

import com.example.gestionstock.Entities.Article;
import com.example.gestionstock.Entities.LigneVente;
import com.example.gestionstock.Entities.Ventes;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {


    private Integer id ;

    private Ventes ventes;


    private Article article;


    private BigDecimal quantite;


    private BigDecimal prixUnitaire;


    private Integer idEntreprise;


    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .ventes(VentesDto.fromEntity(ligneVente.getVentes()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto dto) {
        if (dto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(dto.getId());
        ligneVente.setVentes(VentesDto.toEntity(VentesDto.fromEntity(dto.getVentes())));
        ligneVente.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneVente.setQuantite(dto.getQuantite());
        ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
        ligneVente.setIdEntreprise(dto.getIdEntreprise());
        return ligneVente;
    }

}
