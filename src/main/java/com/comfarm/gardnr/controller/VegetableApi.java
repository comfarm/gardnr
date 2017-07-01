package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.dto.ItemListDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "/", description = "the vegetable API")
public interface VegetableApi {

    @ApiOperation(value = "", notes = "Get vege", response = ItemListDto.class, tags = {"Vegetable","Public"},
            authorizations = {@Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vege", response = ItemListDto.class),
            @ApiResponse(code = 404, message = "Not found", response = ObjectError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.",
                    response = ObjectError.class)})
    @RequestMapping(value = "/vegetables",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<ItemListDto> getAllVegetable();

}

