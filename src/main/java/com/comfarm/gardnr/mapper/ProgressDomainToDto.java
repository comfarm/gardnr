package com.comfarm.gardnr.mapper;

import com.comfarm.gardnr.domain.Progress;
import com.comfarm.gardnr.dto.ProgressDto;
import org.modelmapper.AbstractConverter;

public class ProgressDomainToDto extends AbstractConverter<Progress,ProgressDto>{
    @Override
    protected ProgressDto convert(Progress domain) {
        ProgressDto dto=new ProgressDto();
        dto.setId(domain.getId());
        dto.setContent(domain.getContent());
        dto.setImage(domain.getImage());
        dto.setTanimId(domain.getTanim().getId());
        dto.setTitle(domain.getTitle());
        dto.setProgressDate(domain.getProgressDate());
        return dto;
    }
}
