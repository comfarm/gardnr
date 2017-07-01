package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.dto.NewWikiDto;
import com.comfarm.gardnr.dto.WikiDto;
import com.comfarm.gardnr.dto.WikiListDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.ALL_VALUE;

@Api(value = "/", description = "the wiki API")
public interface WikiApi {

    @ApiOperation(value = "", notes = "Get wiki", response = WikiDto.class, tags = {"Wiki", "Public"},
            authorizations = {@Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Wiki", response = WikiDto.class),
            @ApiResponse(code = 404, message = "Not found", response = ObjectError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/wiki/{wikiId}",
            produces = {"application/json"},
            consumes = {ALL_VALUE},
            method = RequestMethod.GET)
    ResponseEntity<WikiDto> getWikiByIdUsingGET(@ApiParam(value = "wikiId", required = true) @PathVariable("wikiId") Long wikiId);

    @ApiOperation(value = "", notes = "Get wiki under item", response = WikiListDto.class, tags = {"Wiki", "Public"},
            authorizations = {@Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Wiki", response = WikiListDto.class),
            @ApiResponse(code = 404, message = "Not found", response = ObjectError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/wiki/item/{itemId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<WikiListDto> getAllWikiByItemIdUsingGET(@ApiParam(value = "itemId", required = true) @PathVariable("itemId") Long itemId);

    @ApiOperation(value = "", notes = "Get All wiki pages", response = WikiListDto.class, tags = {"Wiki", "Public"},
            authorizations = {@Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "List of wiki", response = WikiListDto.class),
            @ApiResponse(code = 404, message = "Not found", response = ObjectError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/wiki",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<WikiListDto> getAllWikiUsingGET();


    @ApiOperation(value = "", notes = "Create new wiki", response = WikiDto.class, tags = {"Wiki", "Admin"},
            authorizations = {@Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "New Wiki", response = WikiDto.class),
            @ApiResponse(code = 404, message = "Not found", response = ObjectError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ObjectError.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.", response = ObjectError.class)})
    @RequestMapping(value = "/wiki",
            consumes = {"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<WikiDto> createWiki(@ApiParam(value = "newWiki", required = true) @RequestBody NewWikiDto newWiki);

}
