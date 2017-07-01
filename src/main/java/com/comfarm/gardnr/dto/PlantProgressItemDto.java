package com.comfarm.gardnr.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlantProgressItem {
    private List<ProgressDto> progressDtoList;
    private MilestoneDto milestoneDto;

}
