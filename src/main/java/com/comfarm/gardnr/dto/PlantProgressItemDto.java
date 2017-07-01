package com.comfarm.gardnr.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlantProgressItemDto {
    private List<ProgressDto> progressDtoList;
    private MilestoneDto milestoneDto;
    private Date date;
}
