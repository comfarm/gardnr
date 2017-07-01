package com.comfarm.gardnr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlantProgressItemDto {
    private List<ProgressDto> progressDtoList;
    private MilestoneDto milestoneDto;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
}
