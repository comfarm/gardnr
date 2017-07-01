package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.domain.Item;
import com.comfarm.gardnr.dto.ItemDto;
import com.comfarm.gardnr.dto.ItemListDto;
import com.comfarm.gardnr.dto.NewSurveyDto;
import com.comfarm.gardnr.mapper.ItemConverter;
import com.comfarm.gardnr.service.ItemService;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SurveyApiController implements SurveyApi {

    @Autowired
    private ItemService itemService;

    @Override
    public ResponseEntity<ItemListDto> startPlanting(@ApiParam(value = "PlantLocation[backyard,balcony,rooftop,indoors] PlantType[fruits,herbs,house,succulent,vegetable]", required = true) @RequestBody NewSurveyDto request, BindingResult bindingResult) {
        ItemListDto dto=new ItemListDto();
        ModelMapper mapper=new ModelMapper();
        mapper.addConverter(new ItemConverter());
        List<Item> items=itemService.getRandomFour();
        List<ItemDto> itemDtoList=new ArrayList<>();
        items.forEach(item->{
            itemDtoList.add(mapper.map(item,ItemDto.class));
        });
        dto.setItems(itemDtoList);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}