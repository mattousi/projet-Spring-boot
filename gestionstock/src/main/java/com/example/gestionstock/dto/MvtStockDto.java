package com.example.gestionstock.dto;

import com.example.gestionstock.Entities.Article;
import com.example.gestionstock.Entities.MvtStock;
import com.example.gestionstock.Entities.SourceMvtStk;
import com.example.gestionstock.Entities.TypeMvtStk;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStockDto {


    private Integer id ;

    private Instant dateMvt;


    private BigDecimal quantite;


    private ArticleDto article ;


    private TypeMvtStk typeMvt;


    private SourceMvtStk sourceMvt;


    private Integer idEntreprise;


    public static MvtStockDto fromEntity(MvtStock mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStockDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
                .sourceMvt(mvtStk.getSourceMvt())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStock toEntity(MvtStockDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStock mvtStk = new MvtStock();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());
        mvtStk.setSourceMvt(dto.getSourceMvt());
        mvtStk.setIdEntreprise(dto.getIdEntreprise());
        return mvtStk;
    }
}
