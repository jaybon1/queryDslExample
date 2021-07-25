package com.example.market.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ITEM") // 테이블 명
@EqualsAndHashCode(of = "idx", callSuper = false)
public class ItemEntity {

    @Id // 프라이머리 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성 전략
    @Column(name = "idx") // 컬럼명
    private Integer idx;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "discount_yn")
    private String discountYn;

    @Column(name = "price")
    private Integer price;

    @Column(name = "discount_price")
    private Integer discountPrice;

    @Column(name = "product_kind")
    private Integer productKind;

    @Column(name = "product_maker")
    private Integer productMaker;

    @Column(name = "stock")
    private Integer stock; // 재고

}
