package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.dto.ItemListDto;
import com.comfarm.gardnr.dto.NewSurveyDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.ALL_VALUE;

@Api(value = "/", description = "the survey API")
public interface SurveyApi {

    @ApiOperation(value = "", notes = "save survey", response = ItemListDto.class, tags = {"Public"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucessfully saved", response = ObjectError.class),
            @ApiResponse(code = 400, message = "Theres an error on your request.", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/survey",
            produces = {"application/json"},
            consumes = {ALL_VALUE},
            method = RequestMethod.POST)
    ResponseEntity<ItemListDto> startPlanting(@ApiParam(value = "PlantLocation[backyard,balcony,rooftop,indoors] PlantType[fruits,herbs,house,succulent,vegetable]", required = true) @RequestBody NewSurveyDto request, BindingResult bindingResult);

}
