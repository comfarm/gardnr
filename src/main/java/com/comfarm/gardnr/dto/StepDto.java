package com.comfarm.gardnr.dto;

import lombok.Data;

@Data
public class StepDto {

    private Long id;
    private Long stepNum;
    private String content;
    private Long wikiId;
    private String title;
}
