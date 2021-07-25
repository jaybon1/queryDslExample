package com.example.market.querydsl;

import com.example.market.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity,Integer>, ItemCustomRepository {
    // ItemCustomRepository 에서 QueryDsl 매핑 인터페이스 생성
}
