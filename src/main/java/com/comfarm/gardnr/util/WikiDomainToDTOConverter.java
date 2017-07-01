package com.comfarm.gardnr.util;

import com.comfarm.gardnr.domain.Checklist;
import com.comfarm.gardnr.domain.Steps;
import com.comfarm.gardnr.domain.Wiki;
import com.comfarm.gardnr.dto.ChecklistDto;
import com.comfarm.gardnr.dto.StepDto;
import com.comfarm.gardnr.dto.WikiDto;
import org.modelmapper.AbstractConverter;

import java.util.*;

public class WikiDomainToDTOConverter extends AbstractConverter<Wiki, WikiDto> {

    @Override
    protected WikiDto convert(Wiki wiki) {
        WikiDto dto = new WikiDto();
        dto.setChecklist(checklistDomainToDto(wiki.getChecklists(), wiki.getId()));
        dto.setSteps(stepsDomainToDto(wiki.getSteps(), wiki.getId()));
        dto.setItemId(wiki.getItemId());
        dto.setTitle(wiki.getTitle());
        dto.setId(wiki.getId());
        return dto;
    }

    private List<StepDto> stepsDomainToDto(Set<Steps> steps, Long wikiId) {
        List<StepDto> result = new ArrayList<>();
        steps.forEach(step -> {
            StepDto dto = new StepDto();
            dto.setWikiId(wikiId);
            dto.setContent(step.getContent());
            dto.setId(step.getId());
            dto.setStepNum(step.getStepNum());
            dto.setTitle(step.getTitle());
            result.add(dto);
        });
        Collections.sort(result, new Comparator<StepDto>() {
            @Override public int compare(StepDto p1, StepDto p2) {
                return Math.toIntExact(p1.getStepNum() - p2.getStepNum());
            }

        });
        return result;
    }

    private List<ChecklistDto> checklistDomainToDto(Set<Checklist> checklists, Long wikiId) {

        List<ChecklistDto> result = new ArrayList<>();
        checklists.forEach(checklist -> {
            ChecklistDto dto = new ChecklistDto();
            dto.setWikiId(wikiId);
            dto.setCategory(checklist.getChecklistCategory().getName());
            dto.setChecklistCategoryId(checklist.getChecklistCategory().getId());
            dto.setContent(checklist.getContent());
            dto.setName(checklist.getName());
            dto.setId(checklist.getId());
            result.add(dto);
        });
        return result;
    }
}
