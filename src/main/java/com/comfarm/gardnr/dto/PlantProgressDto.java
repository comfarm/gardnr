package com.comfarm.gardnr.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlantProgressDto {
    private List<PlantProgressItemDto> plantProgressLists;
}
