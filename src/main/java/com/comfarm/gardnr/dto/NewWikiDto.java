package com.comfarm.gardnr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NewWikiDto {

    @JsonProperty("title")
    private String title;
    private List<ChecklistDto> checklist;
    private List<StepDto> steps;
    private Long itemId;
}
