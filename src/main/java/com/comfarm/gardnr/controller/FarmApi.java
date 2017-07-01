package com.comfarm.gardnr.controller;


import com.comfarm.gardnr.dto.PlantDto;
import com.comfarm.gardnr.dto.ProgressDto;
import com.comfarm.gardnr.dto.SaveProgressDto;
import com.comfarm.gardnr.dto.StartPlant;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "/", description = "the farm API")
public interface FarmApi {

    @ApiOperation(value = "", notes = "Start planting", response = PlantDto.class, tags = {"Public"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "sucessfully saved", response = ObjectError.class),
            @ApiResponse(code = 400, message = "Theres an error on your request.", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/start",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<PlantDto> startPlanting(@ApiParam(value = "Start PlantDto", required = true) @RequestBody StartPlant request, BindingResult bindingResult);

//
//    @ApiOperation(value = "", notes = "Save progress", response = SaveProgressDto.class, tags = {"Public"})
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "sucessfully saved", response = ObjectError.class),
//            @ApiResponse(code = 400, message = "Theres an error on your request.", response = ObjectError.class),
//            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.",
//                    response = ObjectError.class)})
//    @RequestMapping(value = "/progress",
//            produces = {"application/json"},
//            consumes = {"application/json"},
//            method = RequestMethod.POST)
//    ResponseEntity<ProgressDto> saveProgress(@ApiParam(value = "Save progress", required = true) @RequestBody SaveProgressDto request, BindingResult bindingResult);


    @ApiOperation(value = "", notes = "Save progress with image", response = SaveProgressDto.class, tags = {"Public"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "sucessfully saved", response = ObjectError.class),
            @ApiResponse(code = 400, message = "Theres an error on your request.", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.",
                    response = ObjectError.class)})
    @RequestMapping(value = "/progress",
            produces = {"application/json"},
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE },
            method = RequestMethod.POST)
    ResponseEntity<ProgressDto> saveProgressWithImage(@ApiParam(value = "Save progress", required = true) @ModelAttribute SaveProgressDto request, @RequestPart(value = "file", required = false) MultipartFile file, BindingResult bindingResult);

}
