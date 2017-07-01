package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.dto.PlantProgressDto;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import javax.websocket.server.PathParam;

@Controller
public class TanimController implements TanimApi {

    @Override
    public ResponseEntity<PlantProgressDto> plantProgresss(@ApiParam(value = "Get all progress", required = true) @PathParam("tanimId") long tanimId, BindingResult bindingResult) {
        PlantProgressDto result=new PlantProgressDto();

        return new ResponseEntity<PlantProgressDto>(result, HttpStatus.OK);
    }
}
