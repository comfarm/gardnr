package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.dto.ItemListDto;
import com.comfarm.gardnr.dto.NewSurveyDto;
import com.comfarm.gardnr.dto.PlantProgressDto;
import com.comfarm.gardnr.dto.PlantProgressItemDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

@Api(value = "/", description = "all about your plant")
public interface TanimApi {

    @ApiOperation(value = "", notes = "get plant", response = PlantProgressDto.class, tags = {"Public"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "your plant", response = ObjectError.class),
            @ApiResponse(code = 400, message = "Theres an error on your request.", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/plant/{tanimId}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    List<PlantProgressItemDto> plantProgresss(@ApiParam(value = "Get all progress", required = true) @PathVariable("tanimId") long tanimId);

}
