package com.example.market.querydsl;

import com.example.market.dto.ItemDTO;
import com.example.market.dto.QItemDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.market.entity.QItemEntity.itemEntity;
import static com.example.market.entity.QProductKindEntity.productKindEntity;
import static com.example.market.entity.QProductMakerEntity.productMakerEntity;

// ItemCustomRepository 에서 생성한 인터페이스를 여기서 구현
@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    // 참고 QueryDsl은 from절에 서브쿼리가 불가능하다.
    // 배민에서는 조건을 미리 걸어 쿼리를 하여 리스트를 가져오고
    // 해당 리스트를 다음 쿼리의 where 서브쿼리의 조건으로 넣어서 해결했다고 함.
    @Override
    public List<ItemDTO> findAllByDynamic(Integer searchType, String searchValue) {

        JPAQuery<ItemDTO> query = jpaQueryFactory
                .select(new QItemDTO( // DTO로 리턴
                    itemEntity.idx,
                    new CaseBuilder() // case when,
                        .when(itemEntity.discountYn.eq("Y"))
                            .then(itemEntity.itemName.append(Expressions.stringTemplate("' (할인 중)'")))
                            .otherwise(itemEntity.itemName),
                    itemEntity.discountYn,
                    itemEntity.price,
                    itemEntity.discountPrice,
                    JPAExpressions // 스칼라 서브쿼리
                        .select(productKindEntity.kindName)
                        .from(productKindEntity)
                        .where(productKindEntity.idx.eq(itemEntity.productKind)), productMakerEntity.makerName,
                    itemEntity.stock
                ))
                .from(itemEntity) // 기준 테이블
                .join(productMakerEntity).on(itemEntity.productMaker.eq(productMakerEntity.idx)) // 조인
                .where(customSearch(searchType, searchValue)) // 동적 조건을 위한 함수호출
                .orderBy(itemEntity.idx.desc()); // 역정렬

        return query.fetch();

    }

    // searchType에 따라 동적으로 쿼리를 변경시킨다.
    private BooleanExpression customSearch(Integer searchType, String searchValue){

        BooleanExpression n = itemEntity.itemName.isNotEmpty();

        // 주의 productKindEntity처럼 서브쿼리로 쓰인 테이블은 조건에 넣으면 안된다.
        if (searchType == 1){
            n = n.and(itemEntity.itemName.contains(searchValue));
        } else if (searchType == 2){
            n = n.and(productMakerEntity.makerName.contains(searchValue));
        }

        return n;

    }
}
