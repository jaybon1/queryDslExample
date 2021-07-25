package com.example.market.querydsl;

import com.example.market.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemDTO> findAllByDynamic(Integer searchType, String searchValue){
        return itemRepository.findAllByDynamic(searchType, searchValue);
    }

}

