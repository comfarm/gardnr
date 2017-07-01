package com.comfarm.gardnr.util;

import com.comfarm.gardnr.domain.Steps;
import com.comfarm.gardnr.domain.Wiki;
import com.comfarm.gardnr.dto.StepDto;
import com.comfarm.gardnr.service.WikiService;
import org.modelmapper.AbstractConverter;

public class StepsDtoToDomainConverter extends AbstractConverter<StepDto, Steps> {

    WikiService wikiService;

    public StepsDtoToDomainConverter(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @Override
    protected Steps convert(StepDto stepDto) {
        Steps steps = new Steps();
        steps.setContent(stepDto.getContent());
        steps.setStepNum(stepDto.getStepNum());
        steps.setWiki(getWikiFromWikiId(stepDto.getWikiId()));
        return steps;
    }

    private Wiki getWikiFromWikiId(Long wikiId) {
        return wikiService.getWikiById(wikiId);
    }
}
