package com.comfarm.gardnr.util;

import com.comfarm.gardnr.domain.Checklist;
import com.comfarm.gardnr.domain.ChecklistCategory;
import com.comfarm.gardnr.domain.Wiki;
import com.comfarm.gardnr.dto.ChecklistDto;
import com.comfarm.gardnr.service.WikiService;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class ChecklistDtoToDomainConverter extends AbstractConverter<ChecklistDto, Checklist> {
    WikiService wikiService;

    public ChecklistDtoToDomainConverter(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @Override
    protected Checklist convert(ChecklistDto dto) {
        Checklist checklist = new Checklist();
        checklist.setContent(dto.getContent());
        checklist.setName(dto.getName());
        checklist.setWiki(getWikiFromWikiId(dto.getWikiId()));
        checklist.setChecklistCategory(getCategoryFromCategoryId(dto.getChecklistCategoryId()));
        return checklist;
    }

    private ChecklistCategory getCategoryFromCategoryId(Long categoryId) {
        return wikiService.getCategoryById(categoryId);
    }

    private Wiki getWikiFromWikiId(Long wikiId) {
        return wikiService.getWikiById(wikiId);
    }


}
