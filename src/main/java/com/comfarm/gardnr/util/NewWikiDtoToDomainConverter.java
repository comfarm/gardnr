package com.comfarm.gardnr.util;


import com.comfarm.gardnr.domain.Wiki;
import com.comfarm.gardnr.dto.NewWikiDto;
import org.modelmapper.AbstractConverter;

public class NewWikiDtoToDomainConverter extends AbstractConverter<NewWikiDto,Wiki>{
    @Override
    protected Wiki convert(NewWikiDto wikiDto) {
        Wiki wiki=new Wiki();
        wiki.setTitle(wikiDto.getTitle());
        wiki.setItemId(wikiDto.getItemId());

        return wiki;
    }
}
