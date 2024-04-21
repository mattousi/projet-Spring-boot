package com.example.gestionstock.dto;

import com.example.gestionstock.Entities.LigneVente;

import com.example.gestionstock.Entities.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VentesDto {


    private Integer id ;
    
    private String code;


    private Instant dateVente;


    private String commentaire;


    private Integer idEntreprise;


    private List<LigneVente> ligneVentes;


    public static Ventes fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(Ventes dto) {
        if (dto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(dto.getCommentaire());
        ventes.setIdEntreprise(dto.getIdEntreprise());
        return ventes;
    }
}
