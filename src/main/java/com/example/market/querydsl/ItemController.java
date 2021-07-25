package com.example.market.querydsl;

import com.example.market.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "itemTable")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("")
    public String findAllByDynamic(
            @RequestParam(value = "searchType", defaultValue = "0") Integer searchType,
            @RequestParam(value = "searchValue", defaultValue = "") String searchValue,
            Model model){

        List<ItemDTO> itemDTOList = itemService.findAllByDynamic(searchType, searchValue);

        model.addAttribute("itemDTOList", itemDTOList);

        return "itemTable";
    }

}
