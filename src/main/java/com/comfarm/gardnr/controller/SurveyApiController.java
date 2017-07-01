package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.dto.ItemListDto;
import com.comfarm.gardnr.dto.NewSurveyDto;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SurveyApiController implements SurveyApi {

    @Override
    public ResponseEntity<ItemListDto> startPlanting(@ApiParam(value = "PlantLocation[backyard,balcony,rooftop,indoors] PlantType[fruits,herbs,house,succulent,vegetable]", required = true) @RequestBody NewSurveyDto request, BindingResult bindingResult) {
        ItemListDto result=new ItemListDto();
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}