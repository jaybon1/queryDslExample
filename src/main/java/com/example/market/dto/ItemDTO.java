package com.example.market.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ItemDTO {

    private Integer no;
    private String itemName;
    private String discountYn;
    private Integer price;
    private Integer discountPrice;
    private String productKindName;
    private String productMakerName;
    private Integer stock;

    @QueryProjection // QueryDsl에서 사용하기 위한 어노테이션, Q도메인이 생긴다
    public ItemDTO(Integer no, String itemName, String discountYn, Integer price, Integer discountPrice, String productKindName, String productMakerName, Integer stock) {
        this.no = no;
        this.itemName = itemName;
        this.discountYn = discountYn;
        this.price = price;
        this.discountPrice = discountPrice;
        this.productKindName = productKindName;
        this.productMakerName = productMakerName;
        this.stock = stock;
    }
}
