package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Api(value = "/", description = "the user API")
public interface UserApi {

    @ApiOperation(value = "", notes = "Save User", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "sucessfully saved", response = ObjectError.class),
            @ApiResponse(code = 400, message = "Theres an error on your request.", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/saveUser",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<UserDto> saveUser(@RequestBody UserDto request, BindingResult bindingResult);

    @ApiOperation(value = "", notes = "Get User", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "sucessfully saved", response = ObjectError.class),
            @ApiResponse(code = 400, message = "Theres an error on your request.", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/getUser/{user}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserDto> getUser(@PathParam("user") String user);
}
