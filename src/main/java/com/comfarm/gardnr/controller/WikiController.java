package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.domain.Checklist;
import com.comfarm.gardnr.domain.Steps;
import com.comfarm.gardnr.domain.Wiki;
import com.comfarm.gardnr.dto.NewWikiDto;
import com.comfarm.gardnr.dto.WikiDto;
import com.comfarm.gardnr.dto.WikiListDto;
import com.comfarm.gardnr.dto.WikiListItemDto;
import com.comfarm.gardnr.service.WikiService;
import com.comfarm.gardnr.util.ChecklistDtoToDomainConverter;
import com.comfarm.gardnr.util.NewWikiDtoToDomainConverter;
import com.comfarm.gardnr.util.StepsDtoToDomainConverter;
import com.comfarm.gardnr.util.WikiDomainToDTOConverter;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class WikiController implements WikiApi {

    @Autowired
    private WikiService wikiService;

    @Override
    public ResponseEntity<WikiDto> getWikiByIdUsingGET(@ApiParam(value = "wikiId", required = true) @PathVariable("wikiId") Long wikiId) {
        WikiDto dto = new WikiDto();
        Wiki wiki = wikiService.getWikiById(wikiId);
        if (null == wiki) {
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        }
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new WikiDomainToDTOConverter());
        dto = mapper.map(wiki, WikiDto.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WikiListDto> getAllWikiByItemIdUsingGET(@ApiParam(value = "itemId", required = true) @PathVariable("itemId") Long itemId) {
        WikiListDto result = new WikiListDto();

        List<Wiki> allWiki = wikiService.getAllWikiByItemId(itemId);
        allWiki.forEach(wiki -> {
            result.getWiki().add(new WikiListItemDto(wiki.getId(), wiki.getTitle()));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<WikiListDto> getAllWikiUsingGET() {
        WikiListDto result = new WikiListDto();

        List<Wiki> allWiki = wikiService.getAllWiki();
        allWiki.forEach(wiki -> {
            result.getWiki().add(new WikiListItemDto(wiki.getId(), wiki.getTitle()));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WikiDto> createWiki(@ApiParam(value = "newWiki", required = true) @RequestBody NewWikiDto newWikiDto) {

        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new NewWikiDtoToDomainConverter());
        Wiki newWiki = mapper.map(newWikiDto, Wiki.class);
        Wiki savedWiki = wikiService.saveWiki(newWiki);

        mapper.addConverter(new StepsDtoToDomainConverter(wikiService));
        Set<Steps> steps = new HashSet<>();
        newWikiDto.getSteps().forEach(stepDto -> {
            stepDto.setWikiId(savedWiki.getId());
            steps.add(mapper.map(stepDto, Steps.class));
        });
        List<Steps> saveSteps = wikiService.saveSteps(steps);


        mapper.addConverter(new ChecklistDtoToDomainConverter(wikiService));
        Set<Checklist> checklist = new HashSet<>();
        newWikiDto.getChecklist().forEach(checklistDto -> {
            checklistDto.setWikiId(savedWiki.getId());
            checklist.add(mapper.map(checklistDto, Checklist.class));
        });

        List<Checklist> savedChecklist = wikiService.saveChecklists(checklist);
        savedWiki.setSteps((new HashSet<>(saveSteps)));
        savedWiki.setChecklists((new HashSet<>(savedChecklist)));
        mapper.addConverter(new WikiDomainToDTOConverter());
        WikiDto wikiDto = mapper.map(savedWiki, WikiDto.class);

        return new ResponseEntity<>(wikiDto, HttpStatus.CREATED);
    }

}
