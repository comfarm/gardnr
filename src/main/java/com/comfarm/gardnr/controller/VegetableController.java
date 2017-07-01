package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.domain.Item;
import com.comfarm.gardnr.dto.ItemDto;
import com.comfarm.gardnr.dto.ItemListDto;
import com.comfarm.gardnr.mapper.ItemConverter;
import com.comfarm.gardnr.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VegetableController implements VegetableApi{
    @Autowired
    private ItemService itemService;

    @Override
    public ResponseEntity<ItemListDto> getAllVegetable() {
        ItemListDto dto=new ItemListDto();
        ModelMapper mapper=new ModelMapper();
        mapper.addConverter(new ItemConverter());
        List<Item> items=itemService.getAllVegetables();
        List<ItemDto> itemDtoList=new ArrayList<>();
        items.forEach(item->{
            itemDtoList.add(mapper.map(item,ItemDto.class));
        });
        dto.setItems(itemDtoList);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
