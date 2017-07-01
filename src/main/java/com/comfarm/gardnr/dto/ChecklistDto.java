package com.comfarm.gardnr.dto;

import lombok.Data;

@Data
public class ChecklistDto {

    private Long checklistCategoryId;
    private String name;
    private String content;
    private Long wikiId;
    private String category;
    private Long id;
}
